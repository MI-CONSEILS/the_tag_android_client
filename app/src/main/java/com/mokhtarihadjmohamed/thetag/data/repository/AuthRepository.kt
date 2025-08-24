package com.mokhtarihadjmohamed.thetag.data.repository

import android.util.Log
import com.mokhtarihadjmohamed.thetag.data.datastore.SettingsDataStore
import com.mokhtarihadjmohamed.thetag.data.remote.api.ApiService
import com.mokhtarihadjmohamed.thetag.data.remote.entities.AuthRequest
import com.mokhtarihadjmohamed.thetag.data.remote.entities.AuthResult
import com.mokhtarihadjmohamed.thetag.data.remote.entities.RegisterRequest
import kotlinx.coroutines.flow.firstOrNull
import org.jetbrains.annotations.Blocking
import retrofit2.HttpException

/**
 * This class is who is responsible for the auth and send and return problem
 * if have tow function on form auth and other to see pin status
 */

class AuthRepository(
    private val api: ApiService,
    private val dataStore: SettingsDataStore,
) {
    suspend fun signIn(username: String, password: String): AuthResult<Unit> {
        return try {
            val response = api.signIn(
                request = AuthRequest(
                    email = username,
                    password = password
                )
            )
            dataStore.saveToken(response.token)
            AuthResult.Authorized()
        } catch (e: HttpException) {
            Log.e("error http", e.toString())
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            Log.e("error", e.toString())
            AuthResult.UnknownError()
        }
    }

    suspend fun register(registerRequest: RegisterRequest): AuthResult<Unit> {
        return try {
            val response = api.register(
                request = registerRequest
            )
            AuthResult.Authorized()
        } catch (e: HttpException) {
            Log.e("error http", e.toString())

            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            Log.e("error", e.toString())
            AuthResult.UnknownError()
        }
    }

    suspend fun logout(): AuthResult<Unit> {
        return try {
            val token = dataStore.jwtToken.firstOrNull()

            if (token != null) {
                api.logout("Bearer $token")
                dataStore.clearToken()
            }

            Log.d("token", token.toString())

            AuthResult.Authorized()
        } catch (e: HttpException) {
            Log.e("error http", e.toString())
            if (e.code() == 401) {
                AuthResult.Unauthorized()
            } else {
                AuthResult.UnknownError()
            }
        } catch (e: Exception) {
            Log.e("error", e.toString())
            AuthResult.UnknownError()
        }
    }
}
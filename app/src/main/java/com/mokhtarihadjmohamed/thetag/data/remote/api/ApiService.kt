package com.mokhtarihadjmohamed.thetag.data.remote.api

import com.mokhtarihadjmohamed.thetag.data.remote.entities.AuthRequest
import com.mokhtarihadjmohamed.thetag.data.remote.entities.AuthResponse
import com.mokhtarihadjmohamed.thetag.data.remote.entities.RegisterRequest
import com.mokhtarihadjmohamed.thetag.data.remote.entities.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * this interface is for auth api to login and get pin status
 * and teh singIn function is return AuthResponse and take auth request.
 * */

interface ApiService {
    @POST("login")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun signIn(
        @Body request: AuthRequest
    ): AuthResponse

    @POST("register")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun register(
        @Body request: RegisterRequest
    ): RegisterResponse

    @POST("logout")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun logout(
        @Header("Authorization") token: String
    )

}
package com.mokhtarihadjmohamed.tagwatchproject.Viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.mokhtarihadjmohamed.thetag.data.remote.entities.AuthResult
import com.mokhtarihadjmohamed.thetag.data.remote.entities.RegisterRequest
import com.mokhtarihadjmohamed.thetag.data.repository.AuthRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

/**
 * this view model in for auth
 */

class AuthViewModel(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val resultChannel = Channel<AuthResult<Unit>>()
    val authResults = resultChannel.receiveAsFlow()

    fun signIn(username: String, password: String) {
        viewModelScope.launch {
            val result = authRepository.signIn(
                username = username,
                password = password
            )
            resultChannel.send(result)
        }
    }

    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            val result = authRepository.register(
                registerRequest = registerRequest
            )
            resultChannel.send(result)
        }
    }

    fun logout() {
        viewModelScope.launch {
            val result = authRepository.logout()
            resultChannel.send(result)
        }
    }

    companion object {
        fun Factory(authRepository: AuthRepository): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return AuthViewModel(authRepository) as T
                }
            }
        }
    }
}
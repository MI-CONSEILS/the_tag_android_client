package com.mokhtarihadjmohamed.thetag.data.remote.entities

/**
 * This is class for auth request to use it in api.
 * */

data class AuthRequest(
    val email: String,
    val password: String,
)

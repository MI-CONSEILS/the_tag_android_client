package com.mokhtarihadjmohamed.thetag.data.remote.entities

/**
 * this class is for auth response is what will get from the server.
 */

data class AuthResponse(
    val user: User,
    val token: String,
    val message: String
)





package com.mokhtarihadjmohamed.thetag.data.remote.entities

data class RegisterRequest(
    val first_name: String,
    val last_name: String,
    val email: String,
    val phone: String,
    val password: String? = null,
    val password_confirmation: String? = null,
)

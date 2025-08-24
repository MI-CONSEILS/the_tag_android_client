package com.mokhtarihadjmohamed.thetag.data.remote.entities

data class User(
    val id: Int? = null,
    val first_name: String,
    val last_name: String,
    val email: String,
    val phone: String,
    val role: String? = null,
    val status: String? = null,
    val password: String? = null,
    val confirmationPassword: String? = null,
    val created_at: String? = null,
    val updated_at: String? = null,
)

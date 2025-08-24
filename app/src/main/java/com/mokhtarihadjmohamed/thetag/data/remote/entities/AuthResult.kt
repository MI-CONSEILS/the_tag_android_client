package com.mokhtarihadjmohamed.thetag.data.remote.entities

/**
 * this sealed class is simple class where our app can tall user what happen
 * if information are false or true and what out function return will see it in the login:
 * @see com.mokhtarihadjmohamed.thetag.ui.screens.LogInScreen
 */

sealed class AuthResult<T>(val data: T? = null) {
    class Authorized<T>(data: T? = null) : AuthResult<T>(data)
    class Unauthorized<T> : AuthResult<T>()
    class UnknownError<T> : AuthResult<T>()
}
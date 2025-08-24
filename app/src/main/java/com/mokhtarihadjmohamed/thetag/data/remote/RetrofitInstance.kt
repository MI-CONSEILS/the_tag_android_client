package com.mokhtarihadjmohamed.thetag.data.remote

import com.mokhtarihadjmohamed.thetag.data.remote.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * This is the main file for manage all retrofit api usage in this object will find 2 TODO
 * on for notification api and other for auth and other thing from the main server api
 * why their are tow links because we have 2 server on for push notification and other
 * for order and auth.
 */

object RetrofitInstance {

    // TODO Service api
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://the-tag-backend-1412054986.eu-north-1.elb.amazonaws.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
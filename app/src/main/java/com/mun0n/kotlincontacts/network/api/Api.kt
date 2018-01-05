package com.mun0n.kotlincontacts.network.api

import com.mun0n.kotlincontacts.network.response.model.UserResponseResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface Api {

    @Headers("Content-Type: application/json")
    @GET("/api/")
    fun getContacts(@Query("results") quantity: Integer): Call<UserResponseResult>
}
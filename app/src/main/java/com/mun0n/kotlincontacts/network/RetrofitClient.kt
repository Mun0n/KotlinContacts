package com.mun0n.kotlincontacts.network

import com.mun0n.kotlincontacts.network.api.Api
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitClient {

    val contactsApi: Api
    private val BASE_URL = "https://randomuser.me/"

    init {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(MoshiConverterFactory.create()).build()
        contactsApi = retrofit.create(Api::class.java)
    }
}
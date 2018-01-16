package com.mun0n.kotlincontacts.presentation.interactor

import com.mun0n.kotlincontacts.network.RetrofitClient
import com.mun0n.kotlincontacts.network.response.model.UserResponseResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetUserListInteractor() : Callback<UserResponseResult> {

    private lateinit var responseListener: ResponseListener

    fun execute(responseListener: ResponseListener) {
        this.responseListener = responseListener
        RetrofitClient.contactsApi.getContacts(15).enqueue(this)
    }

    override fun onResponse(call: Call<UserResponseResult>?, response: Response<UserResponseResult>?) {
        if (response!!.isSuccessful) {
            responseListener.onSuccess(response!!.body()?.results ?: ArrayList())
        } else {
            responseListener.onError()
        }
    }

    override fun onFailure(call: Call<UserResponseResult>?, t: Throwable?) {
        responseListener.onError()
    }
}
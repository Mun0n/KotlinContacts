package com.mun0n.kotlincontacts.presentation.interactor

import com.mun0n.kotlincontacts.network.RetrofitClient
import com.mun0n.kotlincontacts.network.response.model.User

class GetUserListInteractor {

    fun execute(success: (List<User>) -> Unit, fail: () -> Unit) {
        val callResponse = RetrofitClient.contactsApi.getContacts(15)
        val response = callResponse.execute()

        if (response.isSuccessful) {
            success(response.body().results)
        } else {
            fail()
        }
    }
}
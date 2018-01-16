package com.mun0n.kotlincontacts.presentation.interactor

import com.mun0n.kotlincontacts.network.response.model.User

interface ResponseListener {

    fun onSuccess(userList: List<User>)

    fun onError()
}
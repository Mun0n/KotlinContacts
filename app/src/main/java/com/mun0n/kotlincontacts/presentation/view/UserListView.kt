package com.mun0n.kotlincontacts.presentation.view

import android.content.Context
import com.mun0n.kotlincontacts.presentation.model.UserModel

interface UserListView {

    fun showLoading()
    fun hideLoading()
    fun showError()
    fun showErrorRequest()
    fun context(): Context
    fun loadUserData(users: Collection<UserModel>)

}

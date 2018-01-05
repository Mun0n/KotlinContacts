package com.mun0n.kotlincontacts.presentation.view

import android.content.Context
import com.mun0n.kotlincontacts.presentation.model.UserModel

interface UserListView {

    fun showLoading(): Void
    fun hideLoading(): Void
    fun showError(): Void
    fun showErrorRequest(): Void
    fun context(): Context
    fun loadUserData(users: Collection<UserModel>): Void

}

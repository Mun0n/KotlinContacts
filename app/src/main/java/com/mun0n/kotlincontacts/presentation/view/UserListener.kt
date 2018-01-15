package com.mun0n.kotlincontacts.presentation.view

import com.mun0n.kotlincontacts.presentation.model.UserModel

interface UserListener {

    fun onUserPhotoClicked(userModel: UserModel)

    fun onDeleteClicked(userModel: UserModel): Void
}
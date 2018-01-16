package com.mun0n.kotlincontacts.presentation.presenter

import com.mun0n.kotlincontacts.network.response.model.User
import com.mun0n.kotlincontacts.presentation.interactor.GetUserListInteractor
import com.mun0n.kotlincontacts.presentation.interactor.ResponseListener
import com.mun0n.kotlincontacts.presentation.mapper.UserModelDataMapper
import com.mun0n.kotlincontacts.presentation.view.UserListView

class UserListPresenter(private var getUserListInteractor: GetUserListInteractor, private var userModelDataMapper: UserModelDataMapper) {

    private var _view: UserListView? = null

    val view
        get() = _view

    fun bind(view: UserListView) {
        this._view = view
    }

    fun unbind() {
        _view = null
    }

    fun getUserData() {
        view?.showLoading()
        getUserListInteractor.execute(object : ResponseListener {
            override fun onSuccess(userList: List<User>) {
                view?.hideLoading()
                view!!.loadUserData(userModelDataMapper.transform(userList))
            }

            override fun onError() {
                view?.hideLoading()
                view!!.showError()
            }

        })
    }
}
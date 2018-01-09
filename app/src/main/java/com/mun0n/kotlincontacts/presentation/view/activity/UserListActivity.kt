package com.mun0n.kotlincontacts.presentation.view.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mun0n.kotlincontacts.R
import com.mun0n.kotlincontacts.presentation.interactor.GetUserListInteractor
import com.mun0n.kotlincontacts.presentation.mapper.UserModelDataMapper
import com.mun0n.kotlincontacts.presentation.model.UserModel
import com.mun0n.kotlincontacts.presentation.presenter.UserListPresenter
import com.mun0n.kotlincontacts.presentation.view.UserListView

class UserListActivity : AppCompatActivity(), UserListView {

    private var userModelDataMapper: UserModelDataMapper = UserModelDataMapper()
    private var interactor: GetUserListInteractor = GetUserListInteractor()
    private var presenter: UserListPresenter = UserListPresenter(interactor, userModelDataMapper)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        presenter.bind(this)
        presenter.getUserData()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun showLoading(): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading(): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError(): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorRequest(): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun context(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loadUserData(users: Collection<UserModel>): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

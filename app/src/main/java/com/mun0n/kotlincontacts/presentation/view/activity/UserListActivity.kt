package com.mun0n.kotlincontacts.presentation.view.activity

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mun0n.kotlincontacts.R
import com.mun0n.kotlincontacts.presentation.model.UserModel
import com.mun0n.kotlincontacts.presentation.view.UserListView

class UserListActivity : AppCompatActivity(), UserListView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
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

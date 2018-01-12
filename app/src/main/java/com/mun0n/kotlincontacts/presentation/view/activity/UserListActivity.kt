package com.mun0n.kotlincontacts.presentation.view.activity

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.mun0n.kotlincontacts.R
import com.mun0n.kotlincontacts.presentation.interactor.GetUserListInteractor
import com.mun0n.kotlincontacts.presentation.mapper.UserModelDataMapper
import com.mun0n.kotlincontacts.presentation.model.UserModel
import com.mun0n.kotlincontacts.presentation.presenter.UserListPresenter
import com.mun0n.kotlincontacts.presentation.view.UserListView
import com.mun0n.kotlincontacts.presentation.view.UserListener
import com.mun0n.kotlincontacts.presentation.view.adapter.UserAdapter
import kotlinx.android.synthetic.main.activity_user_list.*

class UserListActivity : AppCompatActivity(), UserListView, UserListener {

    override fun onUserPhotoClicked(userModel: UserModel): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onDeleteClicked(userModel: UserModel): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var userModelDataMapper: UserModelDataMapper = UserModelDataMapper()
    private var interactor: GetUserListInteractor = GetUserListInteractor()
    private var presenter: UserListPresenter = UserListPresenter(interactor, userModelDataMapper)

    private var progressDialog: ProgressDialog = ProgressDialog(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            supportActionBar!!.setDisplayShowHomeEnabled(false)
            supportActionBar!!.setHomeButtonEnabled(false)
        }

        progressDialog.isIndeterminate = true

        presenter.bind(this)
        presenter.getUserData()

        btRetry.setOnClickListener() { view ->
            presenter.getUserData()
        }

        rvUser.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvUser.setHasFixedSize(true)
        rvUser.layoutManager = LinearLayoutManager(this)
        rvUser.adapter = UserAdapter(this, this)


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

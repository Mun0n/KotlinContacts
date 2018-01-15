package com.mun0n.kotlincontacts.presentation.view.activity

import android.app.ProgressDialog
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
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

    private var userModelDataMapper: UserModelDataMapper = UserModelDataMapper()

    private var interactor: GetUserListInteractor = GetUserListInteractor()
    private var presenter: UserListPresenter = UserListPresenter(interactor, userModelDataMapper)
    private lateinit var progressDialog: ProgressDialog
    private lateinit var userAdapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        setSupportActionBar(toolbar)
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            supportActionBar!!.setDisplayShowHomeEnabled(false)
            supportActionBar!!.setHomeButtonEnabled(false)
        }
        progressDialog = ProgressDialog(this)
        progressDialog.isIndeterminate = true
        progressDialog.setCancelable(false)

        presenter.bind(this)
        presenter.getUserData()

        btRetry.setOnClickListener { view ->
            presenter.getUserData()
        }

        rvUser.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rvUser.setHasFixedSize(true)
        rvUser.layoutManager = LinearLayoutManager(this)
        userAdapter = UserAdapter(this, this)
        rvUser.adapter = userAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun showLoading() {
        progressDialog.setTitle(R.string.progress_title)
        progressDialog.setMessage(getString(R.string.progress_message))
        progressDialog.show()
    }

    override fun hideLoading() {
        progressDialog.hide()
    }

    override fun showError() {
        rvUser.visibility = View.GONE
        llRetry.visibility = View.VISIBLE
    }

    override fun showErrorRequest() {
        Toast.makeText(this, R.string.error_requesting_more_users, Toast.LENGTH_SHORT).show()
    }

    override fun context(): Context {
        return applicationContext
    }

    override fun loadUserData(users: Collection<UserModel>) {
        userAdapter.userList = users.toMutableList()
        rvUser.visibility = View.VISIBLE
        llRetry.visibility = View.GONE
        showUserListSize()
    }

    override fun onUserPhotoClicked(userModel: UserModel) {

    }

    override fun onDeleteClicked(userModel: UserModel): Void {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showUserListSize() {
        Toast.makeText(this,
                String.format("%s: %s", getString(R.string.message_list_size), userAdapter.userList.size),
                Toast.LENGTH_SHORT).show()
    }
}

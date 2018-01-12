package com.mun0n.kotlincontacts.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mun0n.kotlincontacts.R
import com.mun0n.kotlincontacts.presentation.model.UserModel
import com.mun0n.kotlincontacts.presentation.view.UserListener

class UserAdapter(context: Context, userListener: UserListener) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var context: Context = context

    var userList: List<UserModel> = ArrayList()

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        //holder.bindUser()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder? {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size


    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}
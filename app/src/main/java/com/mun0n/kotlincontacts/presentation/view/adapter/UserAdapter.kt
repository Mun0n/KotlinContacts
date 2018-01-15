package com.mun0n.kotlincontacts.presentation.view.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mun0n.kotlincontacts.R
import com.mun0n.kotlincontacts.presentation.model.UserModel
import com.mun0n.kotlincontacts.presentation.utils.CircleTransform
import com.mun0n.kotlincontacts.presentation.view.UserListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_user.view.*

class UserAdapter(var context: Context, userListener: UserListener) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    var userList: MutableList<UserModel> = ArrayList()

    override fun onBindViewHolder(holder: UserViewHolder?, position: Int) {
        val userViewHolder = holder as UserViewHolder
        var userModel: UserModel = getItem(position)
        userViewHolder.displayUser(userModel)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): UserViewHolder? {
        val view = LayoutInflater.from(context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int = userList.size

    private fun getItem(position: Int): UserModel {
        return userList[position]
    }

    fun setUserList(users: Collection<UserModel>) {
        with(users) {
            userList.clear()
            userList.addAll(users)
            notifyDataSetChanged()
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun displayUser(userModel: UserModel) {
            with(userModel) {
                itemView.tvName.text = String.format("%s %s", userModel.firstName, userModel.lastName)
                itemView.tvEmail.text = userModel.email
                itemView.tvPhone.text = userModel.phone
                Picasso.with(itemView.context).load(userModel.urlPictureThumbnail).transform(CircleTransform()).into(
                        itemView.ivPhoto)
            }
        }
    }

}
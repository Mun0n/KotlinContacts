package com.mun0n.kotlincontacts.presentation.mapper

import com.mun0n.kotlincontacts.network.response.model.User
import com.mun0n.kotlincontacts.presentation.model.UserModel
import java.util.HashSet

class UserModelDataMapper {

    fun transform(user: User?): UserModel {
        if (user == null) {
            throw IllegalArgumentException("Cannot transform a null value")
        }
        val userModel = UserModel()
        userModel.firstName = user.name.first
        userModel.lastName = user.name.last
        userModel.urlPictureThumbnail = user.picture.medium
        userModel.urlPictureBig = user.picture.large
        userModel.phone = user.phone
        userModel.gender = user.gender
        userModel.street = user.location.street
        userModel.city = user.location.city
        userModel.state = user.location.state
        userModel.registerDate = user.registered
        userModel.email = user.email
        return userModel
    }

    fun transform(userCollection: Collection<User>?): Collection<UserModel> {
        val usersModel: MutableSet<UserModel>

        if (userCollection != null && !userCollection.isEmpty()) {
            usersModel = HashSet<UserModel>()
            for (user in userCollection) {
                usersModel.add(transform(user))
            }
        } else {
            usersModel = mutableSetOf<UserModel>()
        }

        return usersModel
    }

}
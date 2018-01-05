package com.mun0n.kotlincontacts.presentation.model

data class UserModel(
        var firstName: String = String(),
        var lastName: String = String(),
        var urlPictureThumbnail: String = String(),
        var phone: String = String(),
        var gender: String = String(),
        var street: String = String(),
        var city: String = String(),
        var state: String = String(),
        var registerDate: String = String(),
        var email: String = String(),
        var urlPictureBig: String = String()
)
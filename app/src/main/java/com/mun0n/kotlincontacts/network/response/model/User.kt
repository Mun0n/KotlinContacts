package com.mun0n.kotlincontacts.network.response.model

data class User(
        var gender: String = String(),
        var name: Name = Name(),
        var location: Location = Location(),
        var email: String = String(),
        var login: Login = Login(),
        var dob: String = String(),
        var registered: String = String(),
        var phone: String = String(),
        var cell: String = String(),
        var id: Id = Id(),
        var picture: Picture = Picture(),
        var nat: String = String()
)
package com.mun0n.kotlincontacts.network.response.model

data class User(
        var gender: String = String(),
        var name: String = String(),
        var location: String = String(),
        var email: String = String(),
        var login: String = String(),
        var dob: String = String(),
        var registered: String = String(),
        var phone: String = String(),
        var cell: String = String(),
        var id: String = String(),
        var picture: String = String(),
        var nat: String = String()
)
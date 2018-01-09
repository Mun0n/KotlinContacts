package com.mun0n.kotlincontacts.network.response.model

data class UserResponseResult(
        var results: List<User> = ArrayList(),
        var info: Info
)
package com.mun0n.kotlincontacts.network.response.model

data class Login(
        val usernmame: String = String(),
        val password: String = String(),
        val salt: String = String(),
        val md5: String = String(),
        val sha1: String = String(),
        val sha256: String = String()
)
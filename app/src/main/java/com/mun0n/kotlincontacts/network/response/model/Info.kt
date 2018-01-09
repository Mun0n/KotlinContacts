package com.mun0n.kotlincontacts.network.response.model

data class Info(
        var seed: String = String(),
        var results: Int,
        var page: Int,
        var version: String = String()
)
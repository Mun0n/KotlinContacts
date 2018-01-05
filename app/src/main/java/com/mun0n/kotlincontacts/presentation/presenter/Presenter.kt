package com.mun0n.kotlincontacts.presentation.presenter

interface Presenter {

    fun onResume(): Void
    fun onPause(): Void
    fun onDestroy(): Void

}
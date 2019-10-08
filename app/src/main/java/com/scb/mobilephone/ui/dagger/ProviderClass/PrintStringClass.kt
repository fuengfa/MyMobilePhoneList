package com.scb.mobilephone.ui.dagger.ProviderClass

import android.util.Log

class PrintStringClass(private val message: String) {
    fun printLog() {
        Log.d("dagger2", message)
    }
}
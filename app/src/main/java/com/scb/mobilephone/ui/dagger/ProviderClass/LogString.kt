package com.scb.mobilephone.ui.dagger.ProviderClass

import javax.inject.Inject

class LogString @Inject constructor(private val printString: PrintStringClass) {
    fun showLog() {
        printString.printLog()
    }


}
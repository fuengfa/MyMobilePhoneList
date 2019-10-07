package com.scb.mobilephone.ui.model

import android.os.Handler
import android.os.HandlerThread

class CMWorkerThread(threadName: String) : HandlerThread(threadName) {

    // Room does not allow operations on the main thread as it can makes your UI laggy.

    private lateinit var mWorkerHandler: Handler

    override fun onLooperPrepared() {
        super.onLooperPrepared()
        mWorkerHandler = Handler(looper)
    }

    fun postTask(task: Runnable) {
        mWorkerHandler = Handler(looper)
        mWorkerHandler.post(task)
    }

}
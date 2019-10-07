package com.scb.mobilephone.ui.fragment

import android.content.Context
import androidx.fragment.app.Fragment
import com.scb.mobilephone.ui.activity.Injectable
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragement : Fragment(), Injectable {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
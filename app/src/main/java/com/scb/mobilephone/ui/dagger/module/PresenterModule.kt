package com.scb.mobilephone.ui.dagger.module

import com.scb.mobilephone.ui.activity.MobileDetailInterface
import com.scb.mobilephone.ui.activity.MobileDetailPresenter
import com.scb.mobilephone.ui.dagger.ProviderClass.LogString
import com.scb.mobilephone.ui.dagger.ProviderClass.PrintStringClass
import com.scb.mobilephone.ui.fragment.MobileFragmentPresenter
import com.scb.mobilephone.ui.fragment.MobileFragmentPresenterInterface
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Singleton
    @Provides
    fun provideLogString(): LogString {
        return LogString(
            PrintStringClass(
                "I need tomatoes"
            )
        )
    }

    @Singleton
    @Provides
    fun provideMobileDetailPresenter(): MobileDetailInterface{
        lateinit var listener: MobileDetailInterface
        return MobileDetailPresenter(listener).view
    }

    @Singleton
    @Provides
    fun provideMobileFragmentPresenter(): MobileFragmentPresenterInterface{
        lateinit var listener: MobileFragmentPresenterInterface
        return MobileFragmentPresenter(listener).view
    }

}
package com.scb.mobilephone.ui.dagger.module

import com.scb.mobilephone.ui.dagger.ProviderClass.LogString
import com.scb.mobilephone.ui.dagger.ProviderClass.PrintStringClass
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

}
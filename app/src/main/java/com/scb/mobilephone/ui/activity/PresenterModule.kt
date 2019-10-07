package com.scb.mobilephone.ui.activity

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Singleton
    @Provides
    fun provideLogString(): LogString {
        return LogString(PrintStringClass("I need tomatoes"))
    }

}
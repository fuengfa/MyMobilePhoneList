package com.scb.mobilephone.ui.dagger.module

import com.scb.mobilephone.ui.activity.MainActivity
import com.scb.mobilephone.ui.activity.MobileDetailActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule{

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMainActivity() : MainActivity

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun contributeMobileDetailActivity() : MobileDetailActivity
}
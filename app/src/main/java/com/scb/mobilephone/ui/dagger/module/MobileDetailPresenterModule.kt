package com.scb.mobilephone.ui.dagger.module

import com.scb.mobilephone.ui.activity.MobileDetailActivity
import com.scb.mobilephone.ui.activity.MobileDetailPresenter
import dagger.Module
import dagger.Provides

@Module
class MobileDetailPresenterModule {

    @Provides
    fun provideMobileDetailPresenter(listner: MobileDetailActivity): MobileDetailPresenter {
        return MobileDetailPresenter(listner)
    }

}
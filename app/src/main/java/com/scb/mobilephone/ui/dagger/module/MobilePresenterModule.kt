package com.scb.mobilephone.ui.dagger.module

import com.scb.mobilephone.ui.fragment.MobileFragment
import com.scb.mobilephone.ui.fragment.MobileFragmentPresenter
import dagger.Module
import dagger.Provides

@Module
class MobilePresenterModule {

    @Provides
    fun provideMobilePresenter(listener : MobileFragment) : MobileFragmentPresenter{
        return MobileFragmentPresenter(listener)
    }
}
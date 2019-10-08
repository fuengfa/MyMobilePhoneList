package com.scb.mobilephone.ui.dagger.module

import com.scb.mobilephone.ui.fragment.FavoriteFragment
import com.scb.mobilephone.ui.fragment.MobileFragment
import com.scb.mobilephone.ui.fragment.PicturesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun contributeFavoriteFragment(): FavoriteFragment

    @ContributesAndroidInjector(modules = [MobilePresenterModule::class])
    abstract fun contributeMobileFragment(): MobileFragment

    @ContributesAndroidInjector
    abstract fun contributePicturesFragment(): PicturesFragment

}

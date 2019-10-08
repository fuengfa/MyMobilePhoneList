package com.scb.mobilephone.ui.dagger

import android.app.Application
import com.scb.mobilephone.ui.dagger.module.ActivityModule
import com.scb.mobilephone.ui.dagger.module.FragmentModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityModule::class,
        FragmentModule::class]
)

interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(mobileApplication: MobileApplication)

}

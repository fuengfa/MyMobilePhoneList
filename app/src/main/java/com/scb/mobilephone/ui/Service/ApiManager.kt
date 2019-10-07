package com.scb.mobilephone.ui.Service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiManager {
//    https://scb-test-mobile.herokuapp.com/api/mobiles/
    val mobileService by lazy { createService<MobileListApiService>("https://scb-test-mobile.herokuapp.com/") }

    private inline fun <reified T> createService(baseUrl: String): T =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .run { create(T::class.java) }

}

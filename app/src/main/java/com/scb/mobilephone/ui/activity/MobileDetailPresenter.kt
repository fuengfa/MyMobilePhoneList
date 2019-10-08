package com.scb.mobilephone.ui.activity

import com.scb.mobilephone.ui.Service.ApiManager
import com.scb.mobilephone.ui.model.MobileModel
import com.scb.mobilephone.ui.model.Pictures
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MobileDetailPresenter @Inject constructor(val view: MobileDetailInterface) {

    private var listPictures: ArrayList<Pictures> = ArrayList()

    private val pictureCallback = object : Callback<List<Pictures>> {
        override fun onFailure(call: Call<List<Pictures>>, t: Throwable) {
        }

        override fun onResponse(call: Call<List<Pictures>>, response: Response<List<Pictures>>) {
            listPictures.addAll(response.body()!!)
            view.loadPictures(listPictures)
        }
    }

    fun loadPictures(mobile: MobileModel) {
        listPictures = ArrayList()
        ApiManager.mobileService.pictures(mobile.id).enqueue(pictureCallback)
    }
}
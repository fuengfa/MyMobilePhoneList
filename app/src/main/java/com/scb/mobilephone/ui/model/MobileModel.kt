package com.scb.mobilephone.ui.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MobileModel(
    @SerializedName("brand")
    var brand: String,

    @SerializedName("description")
    var description: String,

    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("price")
    var price: Double,

    @SerializedName("rating")
    var rating: Double,

    @SerializedName("thumbImageURL")
    var thumbImageURL: String,

    @SerializedName("fav")
    var fav: Int = 0

) : Parcelable
package com.scb.mobilephone.ui.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mobile")
data class MobileEntity(
    @PrimaryKey var id: Int,
    @NonNull var name: String,
    @NonNull var description: String,
    @NonNull var brand: String,
    var price: Double,
    var rating: Double,
    var thumbImageURL: String,
    var fav: Int
) {
    fun transformToMobileModel(): MobileModel {
        return MobileModel(
            this.brand, this.description, this.id,
            this.name, this.price, this.rating,
            this.thumbImageURL, this.fav
        )
    }
}
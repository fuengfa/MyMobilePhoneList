package com.scb.mobilephone

import com.scb.mobilephone.ui.model.MobileEntity
import com.scb.mobilephone.ui.model.Pictures

class TestUtil {
    companion object {
        fun createMobile(
            id: Int,
            price: Double = 0.0,
            rating: Double = 0.0,
            name: String = "",
            brand: String = "",
            description: String = "",
            url: String = "",
            favorite: Int = 0
        ): MobileEntity {
            return MobileEntity(
               id,
                name,
                description,
                brand,
                price,
                rating,
                url,
                favorite
            )
        }

        fun createImageMobile(id: Int, mobile_id: Int = 0, url: String = ""): Pictures {
            return Pictures(
                id, mobile_id, url
            )
        }
    }
}
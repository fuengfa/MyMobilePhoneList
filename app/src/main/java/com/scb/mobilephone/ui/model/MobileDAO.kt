package com.scb.mobilephone.ui.model

import androidx.room.*


@Dao
interface MobileDAO {
    @Query("select * from mobile")
    fun queryMobiles(): List<MobileEntity>

    @Query("select * from mobile where id = :id")
    fun queryMobile(id: Int): MobileEntity?

    @Query("delete from mobile where id = :id")
    fun deleteMobilebyID(id: Int)

    @Insert
    fun addMobile(userEntity: MobileEntity)

    @Update
    fun updateMobile(userEntity: MobileEntity)

    @Delete
    fun deleteMobile(userEntity: MobileEntity)
}
package com.scb.mobilephone

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.scb.mobilephone.ui.model.AppDatbase
import com.scb.mobilephone.ui.model.MobileDAO
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RoomDatabaseTest {
    private lateinit var favoriteDAO: MobileDAO
    private lateinit var db: AppDatbase

    @Before
    fun createDB(){
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, AppDatbase::class.java).build()
        favoriteDAO = db.mobileDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val mobileFavorite = TestUtil2.createMobile(1,122.5, 4.9,
            "iPhone", "iPhone","Good", "https", 1)
        favoriteDAO.addMobile(mobileFavorite)
        val idFavorite = favoriteDAO.queryMobiles()
        assertThat(idFavorite[0], CoreMatchers.equalTo(mobileFavorite))
    }
}
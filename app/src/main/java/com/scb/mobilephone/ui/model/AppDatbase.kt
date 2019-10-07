package com.scb.mobilephone.ui.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [MobileEntity::class], version = 1, exportSchema = false)
abstract class AppDatbase : RoomDatabase() {

    abstract fun mobileDao(): MobileDAO

    companion object {
//        private val TAG: String by lazy { AppDatbase::class.java.simpleName }
        private var instance: AppDatbase? = null

        fun getInstance(context: Context): AppDatbase {

            instance?.let {
                return it
            }

            synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatbase::class.java,
                    DATABASE_NAME // #step1
                ).addCallback(object : RoomDatabase.Callback() {
                    // onCreate will be called when the database is created for the first time
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                    }
                })
                    .addMigrations()
                    .build().also {
                        instance = it
                        return instance!!
                    }
            }
        }


        fun destroyInstance() {
            instance = null
        }

        }



    }
package com.example.droidtiketing.database

import android.content.Context
import androidx.room.Room

class DatabaseClient private constructor(context: Context) {
    var appDatabase: AppDatabase

    companion object {
        private var mInstance: DatabaseClient? = null

        @Synchronized
        fun getInstance(context: Context): DatabaseClient? {
            if (mInstance == null) {
                mInstance = DatabaseClient(context)
            }
            return mInstance!!
        }
    }

    init {
        appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, "travel_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}
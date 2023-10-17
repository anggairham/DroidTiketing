package com.example.droidtiketing.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.droidtiketing.database.dao.DatabaseDao
import com.example.droidtiketing.model.ModelDatabase

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}
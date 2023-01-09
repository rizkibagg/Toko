package com.example.toko.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.toko.database.dao.DatabaseDao
import com.example.toko.model.ModelDatabase

@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}
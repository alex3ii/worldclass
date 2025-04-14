package com.example.worldclass.Data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.worldclass.Data.Model.AccountEntity
import com.example.worldclass.Data.dao.AccountDao


@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}
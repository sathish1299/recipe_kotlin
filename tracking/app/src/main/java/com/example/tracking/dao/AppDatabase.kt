package com.example.tracking.dao

import androidx.room.RoomDatabase

abstract class AppDatabase : RoomDatabase() {
    abstract fun expensesDataDao(): ExpensesDataDao
}
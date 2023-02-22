package com.example.tracking.dao

import android.content.Context
import com.google.android.datatransport.runtime.dagger.Module
import com.google.android.datatransport.runtime.dagger.Provides
import javax.inject.Singleton

@Module
object DatabaseModule {
    const val DB_NAME = "kotlin-base.db"

    @Provides
    fun imageDao(appDatabase: AppDatabase): ExpensesDataDao {
        return appDatabase.expensesDataDao()
    }


}
package com.example.tracking.dao

import androidx.lifecycle.LiveData
import androidx.room.Query
import com.example.tracking.data.Expenses

interface ExpensesDataDao {
    @Query("select * from expenses")
    fun getAllImages(): LiveData<List<Expenses>>
}
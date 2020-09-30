package com.example.testground.lockdatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LockTimeDatabaseDOA {
    @Insert
    fun insert(entry:LockTime)

    @Query("SELECT * from time_lock_table WHERE lockId = :key")
    fun get(key: Long): LockTime?
}
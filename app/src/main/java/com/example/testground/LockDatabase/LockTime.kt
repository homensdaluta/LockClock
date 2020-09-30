package com.example.testground.lockdatabase

import androidx.room.ColumnInfo
import java.time.LocalDateTime
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "time_lock_table")
data class LockTime(
    @PrimaryKey(autoGenerate = true)
    val lockId: Long = 0L,
    @ColumnInfo(name="start_time")
    val startTime: LocalDateTime,
    @ColumnInfo(name="stop_time")
    val stopTime: LocalDateTime) {

}
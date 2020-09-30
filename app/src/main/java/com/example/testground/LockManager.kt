package com.example.testground


import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.time.LocalDateTime

public object LockManager {

    private lateinit var startTime : LocalDateTime
    private lateinit var stopTime : LocalDateTime
    public lateinit var entryTime : LockTime
        private set


    @RequiresApi(Build.VERSION_CODES.O)
    public fun initClock() {
      entryTime=LockTime(LocalDateTime.now(), LocalDateTime.now())
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun startClock(){
        startTime= LocalDateTime.now()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun stopClock(){
        stopTime= LocalDateTime.now()
        entryTime= LockTime(startTime, stopTime)

    }


}
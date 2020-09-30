package com.example.testground.lockstuff


import android.os.Build
import androidx.annotation.RequiresApi
import com.example.testground.lockdatabase.LockTime
import java.time.LocalDateTime

public object LockManager {

    private lateinit var startTime : LocalDateTime
    private lateinit var stopTime : LocalDateTime
    public lateinit var entryTime : LockTime
        private set


    @RequiresApi(Build.VERSION_CODES.O)
    public fun initClock() {
      entryTime =
          LockTime(
              0,
              LocalDateTime.now(),
              LocalDateTime.now()
          )
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun startClock(){
        startTime = LocalDateTime.now()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    public fun stopClock(){
        stopTime = LocalDateTime.now()
        entryTime =
            LockTime(
                0,
                startTime,
                stopTime
            )

    }


}
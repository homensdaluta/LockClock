package com.example.testground.lockstuff

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import com.example.testground.lockstuff.LockManager
import com.example.testground.databinding.ActivityMainBinding


object LockReceiver : BroadcastReceiver(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onReceive(context: Context, intent: Intent) {
        when(intent.action){
            Intent.ACTION_SCREEN_OFF -> LockManager.startClock()
            Intent.ACTION_SCREEN_ON -> LockManager.stopClock()
        }

    }
}
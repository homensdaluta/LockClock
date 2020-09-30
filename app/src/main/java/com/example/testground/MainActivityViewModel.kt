package com.example.testground

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.testground.lockstuff.LockManager

@RequiresApi(Build.VERSION_CODES.O)
class MainActivityViewModel : ViewModel(){
    init {
        LockManager.initClock()
    }
}
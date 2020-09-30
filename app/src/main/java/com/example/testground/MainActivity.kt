package com.example.testground

import android.content.Intent
import android.content.IntentFilter
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.testground.lockstuff.LockManager
import com.example.testground.lockstuff.LockReceiver
import com.example.testground.databinding.ActivityMainBinding


//import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myToast :Toast
    private lateinit var viewModel: MainActivityViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        myToast= Toast.makeText(this, "", Toast.LENGTH_LONG)
        binding.manager= LockManager
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onStop() {
        super.onStop()
        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        registerReceiver(LockReceiver,filter)
    }

    override fun onStart() {
        super.onStart()
        binding.invalidateAll()
    }


}
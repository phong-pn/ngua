package com.example.ngua.service

import android.app.Service
import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.IntentFilter
import android.os.IBinder
import android.util.Log
import com.example.ngua.LockActivity
import com.example.ngua.MainActivity
import com.example.ngua.ui.LockScreen
import com.example.ngua.utils.TAG_APP
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ScreenService : Service() {
    private  var broadcast : ScreenBroadcast? = null
    private var intent : IntentFilter? = null
    private lateinit var lockScreen : LockScreen

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG_APP, "Screen Service is Ok")
         broadcast = ScreenBroadcast(this).also { Log.d(TAG_APP,"Broadcast is ok") }
         intent = IntentFilter().apply {
            addAction(Intent.ACTION_SCREEN_OFF)
            addAction(Intent.ACTION_SCREEN_ON)
             addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
            addCategory(Intent.CATEGORY_DEFAULT)
        }
        registerReceiver(broadcast, intent)?.let { Log.d(TAG_APP, "Receive result intent from broadcast ") }




    }
    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(broadcast)

        Log.d(TAG_APP, "ScreenService is destroy")
    }

    fun startLockActivity() = Unit
}
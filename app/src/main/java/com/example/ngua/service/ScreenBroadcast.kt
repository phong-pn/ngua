package com.example.ngua.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.Intent.ACTION_SCREEN_OFF
import android.content.Intent.ACTION_SCREEN_ON
import android.util.Log
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.example.ngua.utils.ACTION_START_LOCKACTVITY
import com.example.ngua.utils.TAG_APP


class ScreenBroadcast ( val service: ScreenService): BroadcastReceiver() {


    private  val TAG = "Screen status"
    override fun onReceive(context: Context?, intent: Intent?) {
        val action = intent?.action
        Log.d(TAG_APP, "it!!")
        action.let {
            Log.d(TAG_APP, it!!)
        }
        if(action.equals(ACTION_SCREEN_OFF))
            Log.d(TAG_APP,"Screen off")


        if(action.equals(ACTION_SCREEN_ON)) {
            Log.d(TAG_APP, "Screen on")
            service.startLockActivity()

        }

        if (action==Intent.ACTION_AIRPLANE_MODE_CHANGED || action == Intent.ACTION_USER_FOREGROUND || action == Intent.ACTION_USER_BACKGROUND){
            Log.d(TAG_APP,"ok" )

        }


    }

}
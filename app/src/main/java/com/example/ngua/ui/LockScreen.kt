package com.example.ngua.ui

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import android.telephony.ims.RcsUceAdapter
import android.util.Log
import android.view.*
import android.view.WindowManager.LayoutParams
import android.view.WindowManager.LayoutParams.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.getSystemService
import com.example.ngua.MainActivity
import com.example.ngua.R
import com.example.ngua.utils.TAG_APP
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class LockScreen (
 val context: Context
) {
    private val windowManager =  context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    private lateinit var lockScreen: View
    private lateinit var params : LayoutParams

    init {
        inflateLockScreen()
    }

    fun inflateLockScreen(){

        val metrics = context.resources.displayMetrics
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        lockScreen = inflater.inflate(R.layout.lock_screen, null) as View
        val layoutType = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                TYPE_APPLICATION_OVERLAY
            } else {
                TODO("VERSION.SDK_INT < O")
            }
        } else {
            TYPE_TOAST
        }
        params = LayoutParams(
            (metrics.widthPixels * 0.5f).toInt(),
            (metrics.heightPixels * 0.5f).toInt(),
            layoutType,
            FLAG_NOT_FOCUSABLE or FLAG_SHOW_WHEN_LOCKED or FLAG_NOT_TOUCH_MODAL or FLAG_ALLOW_LOCK_WHILE_SCREEN_ON
            ,
            PixelFormat.TRANSLUCENT
        ).also {
            it.gravity = Gravity.CENTER
       //     it.token = context.window.attributes.token



        }
    }

    fun addLockSCreen(){
        try {
            windowManager.addView(lockScreen, params)
        }
        catch (e : Exception){
            Log.d(TAG_APP, e.message!!)
            e.printStackTrace()
        }

    }

    fun removeLockScreen(){
        try {
            windowManager.removeView(lockScreen)
        }
        catch (e : Exception){
            Log.d(TAG_APP, e.message!!)
        }

    }

}
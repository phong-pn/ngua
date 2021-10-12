package com.example.ngua

import android.content.Context
import android.graphics.PixelFormat
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.ViewTreeObserver
import android.view.Window
import android.view.WindowManager
import com.example.ngua.ui.LockScreen
import com.example.ngua.utils.TAG_APP
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.time.Year

class LockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        showOnLockScreen()
        super.onCreate(savedInstanceState)
     //   window.addFlags(WindowManager.LayoutParams)
        val metrics = resources.displayMetrics

//        val params = WindowManager.LayoutParams(
//            (metrics.widthPixels * 0.5f).toInt(),
//            (metrics.heightPixels * 0.5f).toInt(),
//            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY ,
//            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
//            PixelFormat.TRANSLUCENT
//        ).also {
//            it.gravity = Gravity.CENTER
//            window.attributes = it
//            //     it.token = context.window.attributes.token
//


//        }
        setContentView(R.layout.activity_lock)
//        val lockScreen = LockScreen(this).apply { addLockSCreen() }
//        runBlocking { delay(2000) }
    //    finish()
    }
    fun showOnLockScreen(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            setShowWhenLocked(true)
            setTurnScreenOn(true)
        }
        else window.addFlags(
            WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED
                    or WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
        )

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG_APP, "LockScreen Destroy")
    }
}
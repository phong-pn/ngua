package com.example.ngua

import android.app.*
import android.content.Context

import android.content.Intent
import android.content.res.Configuration
import android.graphics.PixelFormat
import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.*
import android.view.WindowManager.LayoutParams
import android.view.WindowManager.LayoutParams.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.ngua.service.ScreenService
import com.example.ngua.ui.LockScreen
import com.example.ngua.utils.TAG_APP
import com.example.ngua.viewmodel.ItchyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var itchyViewModel : ItchyViewModel
    @Inject lateinit var formater : SimpleDateFormat
    private val CHANNEL_ID = "heads_up_alerts"
    private val CHANNEL_NAME = "Heads Up Alerts"

    private lateinit var decorView: View
    private lateinit var lp : WindowManager.LayoutParams
    private lateinit var viewGroup: ViewGroup

     lateinit var notificationManager : NotificationManagerCompat

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) return

        val channel = NotificationChannel(
            CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH
        ).apply {
            lockscreenVisibility = Notification.VISIBILITY_PUBLIC
        }

        notificationManager.createNotificationChannel(channel)



    }
    @RequiresApi(Build.VERSION_CODES.O_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        decorView = window.decorView
        lp = window.attributes
        window.apply {
            addFlags(FLAG_DIM_BEHIND)
            lp.dimAmount = 0.4f

        }

        setShowWhenLocked(true)
        setTurnScreenOn(true)

        super.onCreate(savedInstanceState)

        itchyViewModel = ViewModelProvider(this).get(ItchyViewModel::class.java)

        val NOTIFICATION_ID = 24756
        notificationManager = NotificationManagerCompat.from(this)
        createNotificationChannel()
        val serviceIntent = Intent(this, ScreenService::class.java).apply { startService(this) }

        var a = resources.configuration
      //  a.screenHeightDp = metrics.heightPixels/2f.toInt()
        createConfigurationContext(
            a
        )


       Log.d(TAG_APP, a.toString())

        setContentView(R.layout.activity_main)



        //notificationManager.notify(NOTIFICATION_ID, createNotification())
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        resources.displayMetrics.also { metrics ->
            decorView.layoutParams.apply {
                height = metrics.heightPixels/2
                width = metrics.widthPixels/2
                window.setLayout(width,height)

            }
        }

        Log.d(TAG_APP, window.attributes.width.toString())
    }


    override fun attachBaseContext(newBase: Context?) {


        super.attachBaseContext(newBase?.createConfigurationContext(Configuration().apply {
            screenHeightDp = 300
            this.screenLayout = Configuration.SCREENLAYOUT_SIZE_SMALL or Configuration.SCREENLAYOUT_LONG_YES
        }))
    }







    private fun createNotification() : Notification{
        val contentIntent = Intent(this, MainActivity::class.java)
        val contentPendingIntent = PendingIntent.getActivity(this, 0, contentIntent, 0)

        val fullScreenIntent = Intent(this, LockActivity::class.java)
        val fullScreenPendingIntent = PendingIntent.getActivity(this, 0, fullScreenIntent, 0)


        return NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setColor(ResourcesCompat.getColor(this.resources, R.color.purple_200, null))
            .setContentTitle("ahihi")
            .setContentIntent(contentPendingIntent)
           // .setFullScreenIntent(fullScreenPendingIntent,true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setCategory(NotificationCompat.CATEGORY_CALL)
            .setOngoing(true)
            .build()
    }


    override fun onResume() {
        super.onResume()

    }

}


























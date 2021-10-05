package com.example.ngua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider

import com.example.ngua.entity.ItchLog
import com.example.ngua.viewmodel.ItchyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var itchyViewModel : ItchyViewModel
    @Inject lateinit var formater : SimpleDateFormat
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        itchyViewModel = ViewModelProvider(this).get(ItchyViewModel::class.java)



    }
}
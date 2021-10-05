package com.example.ngua.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.ngua.entity.ItchLog
import com.example.ngua.room.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ItchyViewModel @Inject constructor(
    private val repository: Repository,
    private val formater : SimpleDateFormat
):ViewModel(){
    fun insertItch(log: ItchLog) = GlobalScope.launch {
        withContext(Dispatchers.IO){
            repository.insertItch(log)
        }

    }

    fun updateItch(log: ItchLog) = runBlocking(Dispatchers.IO) {
        repository.updateItch(log)
    }

    fun getAllItchLog() : List<ItchLog>? {
        var logs : List<ItchLog>? = null
        runBlocking(Dispatchers.IO) {
            logs = async { repository.getAllItchLog() }.await()
        }
        return logs
    }

    fun getItchLog(date: String) : ItchLog? {
        var log : ItchLog? = null
        runBlocking(Dispatchers.IO){
            log = async { repository.getItchLog(date) }.await()
        }
        return log
    }

    fun getItchLogToday() = getItchLog(formater.format(Date()))
}
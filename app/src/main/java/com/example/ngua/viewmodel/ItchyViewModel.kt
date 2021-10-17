package com.example.ngua.viewmodel

import androidx.lifecycle.ViewModel
import com.example.ngua.entity.ItchLog
import com.example.ngua.room.ItchRepository
import com.example.ngua.room.interfaces.IRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class ItchyViewModel @Inject constructor(
    private val formatter : SimpleDateFormat,
    private val repository: ItchRepository
):ViewModel(){
    init {
        insert(
            ItchLog(
                lowerArm = 1,
                date = formatter.format(Date())
            )
        )
    }

    private fun insert(log: ItchLog) = runBlocking(Dispatchers.IO){
            repository.insert(log)
        }

    private fun update(log: ItchLog) = runBlocking(Dispatchers.IO) {
        repository.update(log)
    }

    private fun getAllItchLog() : List<ItchLog>? {
        var logs: List<ItchLog>?
        runBlocking(Dispatchers.IO) {
            logs =
                withContext(Dispatchers.IO) { repository.getAll() }
        }
        return logs
    }

    private fun getItchLog(date: String) : ItchLog? {
        var log: ItchLog?
        runBlocking(Dispatchers.IO){
            log = withContext(Dispatchers.IO) {
                repository.get(date)
            }
        }
        return log
    }

    fun getItchLogToday() = getItchLog(formatter.format(Date()))
}
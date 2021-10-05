package com.example.ngua.room

import com.example.ngua.entity.ItchLog
import java.util.*
import javax.inject.Inject

class Repository @Inject constructor(
    private val itchDao: ItchDao
){
    suspend fun insertItch(log: ItchLog) = itchDao.insert(log)

    suspend fun updateItch(log: ItchLog) = itchDao.updateLog(log)

    suspend fun getAllItchLog() = itchDao.getAllItchLog()

    suspend fun  getItchLog(date: String) = itchDao.getItchLog(date)
}
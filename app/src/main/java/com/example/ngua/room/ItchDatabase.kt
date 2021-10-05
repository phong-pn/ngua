package com.example.ngua.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.ngua.entity.ItchLog
import com.example.ngua.utils.TypeConverter

@Database(entities = arrayOf(ItchLog::class), version = 1, exportSchema = false)
@TypeConverters(TypeConverter::class)
abstract class ItchDatabase : RoomDatabase(){
    abstract fun getItchDao() : ItchDao
}
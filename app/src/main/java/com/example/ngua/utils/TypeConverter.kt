package com.example.ngua.utils

import androidx.room.TypeConverter
import java.util.*

class TypeConverter {
    @TypeConverter
    fun fromLong(dateLong: Long): Date? = Date(dateLong)

    @TypeConverter
    fun dateToLong(date: Date) = date.time


}
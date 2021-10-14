package com.example.ngua.room.interfaces

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.ngua.entity.ItchLog

interface Dao<T,R> {
    @Update(onConflict = REPLACE)
    suspend fun update(t : T)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(t : T)

    @Delete
    suspend fun delete(t : T)

}
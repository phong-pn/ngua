package com.example.ngua.room

import androidx.room.*
import androidx.room.Dao
import com.example.ngua.entity.ItchLog
import com.example.ngua.room.interfaces.IDao


@Dao
interface ItchDao : IDao<ItchLog> {

    @Query("Select * from itchLog")
    suspend fun  getAll() : List<ItchLog>

    @Query("SELECT * FROM itchLog i WHERE i.date = :date")
    suspend fun  get(date: String): ItchLog
}


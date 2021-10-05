package com.example.ngua.room

import androidx.room.*
import com.example.ngua.entity.ItchLog
import java.util.*


@Dao
interface ItchDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(log: ItchLog)

    @Update
    suspend fun updateLog(log: ItchLog)

    @Query("Select * from itchLog")
    fun getAllItchLog() : List<ItchLog>?

    @Query("SELECT * FROM itchLog i WHERE i.date = :date")
    fun getItchLog(date: String): ItchLog?
}
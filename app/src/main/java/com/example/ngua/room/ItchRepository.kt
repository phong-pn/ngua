package com.example.ngua.room

import com.example.ngua.entity.ItchLog
import com.example.ngua.room.interfaces.IRepository
import javax.inject.Inject

class ItchRepository @Inject constructor(
    private val dao : ItchDao
): IRepository<ItchLog> {


    override suspend fun update(log: ItchLog) = dao.update(log)

    override suspend fun insert(log: ItchLog) = dao.insert(log)

    override suspend fun delete(log: ItchLog) = dao.delete(log)

    override suspend fun getAll() = dao.getAll()

    override suspend fun get(date: String) = dao.get(date)
}
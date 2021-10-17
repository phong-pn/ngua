package com.example.ngua.room.interfaces

interface IRepository<T>{
    suspend fun update(t : T)

    suspend fun insert(t : T)

    suspend fun delete(t : T)

    suspend fun  getAll() : List<T>

    suspend fun get(date : String) : T
}
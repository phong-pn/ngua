package com.example.ngua.room.`interface`

interface IRepository {
    suspend fun<T> update(t : T)

    suspend fun <T> insert(t : T)

    suspend fun <T> delete(t : T)

    suspend fun <T> getAll() : T

    suspend fun <T,R> get(param : T) : R
}
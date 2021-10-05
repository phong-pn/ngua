package com.example.ngua.di

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.ngua.room.ItchDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule  {

    @Provides
    @Singleton
    fun provideItchDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, ItchDatabase::class.java , "itch_db")
        .addCallback(object : RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                Log.d("ngua","Create DB ")
            }
        })
        .build()


    @Provides
    @Singleton
    fun provideItchDao(db: ItchDatabase) = db.getItchDao()


}
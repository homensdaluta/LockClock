package com.example.testground.lockdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [LockTime::class],version = 1,exportSchema = true)
abstract class LockTimeDatabase:RoomDatabase(){

    abstract val lockTimeDoa:LockTimeDatabaseDOA

    @Volatile
    private var INSTANCE: LockTimeDatabase? = null
    fun getInstance(context: Context): LockTimeDatabase {
        synchronized(this) {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    LockTimeDatabase::class.java,
                    "lock_history_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
            }
            return instance
        }
    }
}
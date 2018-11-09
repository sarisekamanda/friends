package com.example.sarise.friends.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.experimental.CoroutineScope

@Database(entities = [Friends::class], version = 1)
abstract class FriendsDatabase: RoomDatabase(){
    
    abstract fun friendDAO(): FriendsDao

    companion object {

        @Volatile
        private var INSTANCE: FriendsDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope): FriendsDatabase{
                return INSTANCE ?: synchronized(this){
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        FriendsDatabase::class.java,
                        "friends-database"
                    )

                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                    instance
                }
        }
    }

}
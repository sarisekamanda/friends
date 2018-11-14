package com.example.sarise.friends.db

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.IO
import kotlinx.coroutines.experimental.launch

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

    private class FriendsDatabaseCallBAck(
        private val scope: CoroutineScope
    ): RoomDatabase.Callback(){

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {database ->
                scope.launch(Dispatchers.IO) {
                    populaTabela(database.friendDAO())
                }
            }
        }
    }

    fun populaTabela(friendsDao: FriendsDao){
        friendsDao.deleteAll()
        friendsDao.insert(Friends(id = 1, nome = "Arise"))
        friendsDao.insert(Friends(id = 2, nome = "Allan"))
        friendsDao.insert(Friends(id = 3, nome = "Prof"))
    }
}
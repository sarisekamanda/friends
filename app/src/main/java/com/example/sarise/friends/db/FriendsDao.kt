package com.example.sarise.friends.db

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface FriendsDao {

    @Insert
    fun insert (friends: Friends)

    @Query("DELETE FROM friends_table")
    fun deleteAll()

    @Query("SELECT * FROM friends_table")
    fun getAll():LiveData<List<Friends>>

}
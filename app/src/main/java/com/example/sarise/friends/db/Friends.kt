package com.example.sarise.friends.db

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "friends_table")
data class Friends(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name ="id")
    val id: Int,

    @ColumnInfo(name =" nome")
    var nome: String,

    @ColumnInfo(name = "telefone")
    var telefone: String = ""

)
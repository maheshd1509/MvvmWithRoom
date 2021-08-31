package com.example.mvvmwithroom.room

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "LoginDetails")
class LoginDetails {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var UserName: String? = null
    var password: String? = null
}

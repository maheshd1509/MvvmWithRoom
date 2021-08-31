package com.example.mvvmwithroom.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query



@Dao
interface ApplicationDAOclass {
    @Insert
    fun insertValueInDB(loginDetailsModel: LoginDetails)

    @Query("Select * from LoginDetails")
    fun getLoginData(): LiveData<LoginDetails>
}

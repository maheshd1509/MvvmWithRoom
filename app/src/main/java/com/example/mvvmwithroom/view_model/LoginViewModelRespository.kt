package com.example.mvvmwithroom.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.mvvmwithroom.room.ApplicationDAOclass
import com.example.mvvmwithroom.room.ApplicationDatabaseClass
import com.example.mvvmwithroom.room.LoginDetails


class LoginViewModelRespository(var context: Application) {
    var  applicationDAOclass: ApplicationDAOclass?

    init {
       applicationDAOclass= ApplicationDatabaseClass.newInstance(context)?.applicationDAOclass()
    }


    fun getData(): LiveData<LoginDetails>? {
        return applicationDAOclass?.getLoginData()
    }

    fun addDetails(loginDetails: LoginDetails){
        applicationDAOclass?.insertValueInDB(loginDetails)
    }
}

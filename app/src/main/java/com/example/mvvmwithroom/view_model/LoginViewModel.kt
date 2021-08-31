package com.example.mvvmwithroom.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithroom.room.LoginDetails


class LoginViewModel() : ViewModel(){
    lateinit var loginViewModelRespository: LoginViewModelRespository
    var loginDetails: LiveData<LoginDetails>?=null
    lateinit var context:Application

    fun initilize(context: Application) {
        loginViewModelRespository = LoginViewModelRespository(context)
    }

    fun addDetails(loginDetails: LoginDetails){
        loginViewModelRespository?.addDetails(loginDetails)
    }

    fun getData():LiveData<LoginDetails>?{
       loginDetails=loginViewModelRespository?.getData()
       return loginDetails
    }


}

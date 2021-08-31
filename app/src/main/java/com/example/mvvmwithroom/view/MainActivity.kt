package com.example.mvvmwithroom.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithroom.R
import com.example.mvvmwithroom.room.LoginDetails
import com.example.mvvmwithroom.view_model.LoginViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnClickListener {

    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


          loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
          loginViewModel.initilize(application)

          btn_login?.setOnClickListener(this)
          tv_registration.setOnClickListener(this)

    }



    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_login ->{
                loginViewModel.getData()?.observe(this, object :Observer<LoginDetails>{
                    override fun onChanged(t: LoginDetails?) {
                        if(t?.UserName?.equals(et_user_name?.text.toString())?:false){
                            Toast.makeText(this@MainActivity, "Login Successfully", Toast.LENGTH_LONG).show()
                        }else {
                            Toast.makeText(this@MainActivity, "Login failed for ${et_user_name?.text?.toString()}", Toast.LENGTH_LONG).show()
                        }
                    }
                })
            }
            R.id.tv_registration ->{
               var intend=Intent(this,RegistrationActivity::class.java)
                startActivityForResult(intend,101)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 101){


            var loginDetails=LoginDetails()
            loginDetails.UserName=data?.getStringExtra("User Name")
            loginDetails.password=data?.getStringExtra("Password")

            loginViewModel.addDetails(loginDetails)
        }
    }
}
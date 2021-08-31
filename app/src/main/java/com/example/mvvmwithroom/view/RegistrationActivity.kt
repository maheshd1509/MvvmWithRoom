package com.example.mvvmwithroom.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mvvmwithroom.R
import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() ,View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btn_add.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btn_add->{
                var intend=Intent()
                intend.putExtra("User Name",et_user_name.text.toString())
                intend.putExtra("Password",et_password.text.toString())
                setResult(101,intend)
                finish()
            }
        }
    }

}
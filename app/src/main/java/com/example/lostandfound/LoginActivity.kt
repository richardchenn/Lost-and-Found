package com.example.lostandfound

import android.content.ContentValues.TAG
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.view.View.OnClickListener

class LoginActivity: AppCompatActivity(){


    protected lateinit var editTextEmail: EditText
    protected lateinit var editTextPassword: EditText
    protected lateinit var signInButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        //editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        //signInButton = findViewById<Button>(R.id.loginbutton)


//        signInButton.setOnClickListener{
//            if (editTextEmail!!.text.toString() == "admin" &&
//                editTextEmail!!.text.toString() == "admin"){
//                Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
//            }
//        }


    }

//    fun userLogin(v:View?){
//        if (editTextEmail.text.toString() == "admin" &&
//            editTextEmail.text.toString() == "admin"){
//            Toast.makeText(applicationContext, "Correct", Toast.LENGTH_SHORT).show()
//
//        }
//    }



}
package com.example.android.sahayata.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.android.sahayata.MainActivity
import com.example.android.sahayata.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Exception

class LoginActivity : AppCompatActivity() {


    lateinit var etEmail: EditText
    lateinit var etPassword: EditText
    lateinit var tvreg: TextView
    lateinit var login_btn: Button
    lateinit var loginProgress: ProgressBar

    lateinit var mAuth: FirebaseAuth
    lateinit var fstore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //Firebase init

        mAuth = FirebaseAuth.getInstance()
        fstore = FirebaseFirestore.getInstance()

        //View init

        etEmail = findViewById(R.id.et_first_email)
        etPassword = findViewById(R.id.editTextPassword)
        tvreg = findViewById(R.id.tv_register)
        login_btn = findViewById(R.id.login_btn)
        loginProgress = findViewById(R.id.login_progress)

//        val bottonregister = findViewById<View>(R.id.tv_register)

//        @Suppress("DEPRECATION")
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//            // for now i have changes hide to show status bar
//            window.insetsController?.show(WindowInsets.Type.statusBars())
//
//        } else {
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN
//            )
//        }
        loginProgress.isInvisible

        login_btn.setOnClickListener {
            loginFun()
        }

        tvreg.setOnClickListener {
            val newUser = Intent(this, RegisterActivity::class.java)
            startActivity(newUser)
        }


    }

    private fun loginFun() {
        loginProgress.isVisible

        //init normal val
        var login_email: String
        var login_password: String

        //getting data from xml
        login_email = etEmail.text.toString()
        login_password = etPassword.text.toString()

        //Login logic for firebase

        mAuth.signInWithEmailAndPassword(login_email, login_password)
            .addOnCompleteListener { authResult ->

                try {
                    if (authResult.isSuccessful) {
                        Toast.makeText(this, "Hello Soldier", Toast.LENGTH_SHORT).show()
                        loginProgress.isInvisible
                        val loginIntent = Intent(this, MainActivity::class.java)
                        startActivity(loginIntent)

                    }

                } catch (e: Exception) {
                    Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
                }


            }


    }

}





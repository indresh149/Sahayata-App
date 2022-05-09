package com.example.android.sahayata.activities

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Button
import com.example.android.sahayata.R

class RegisterActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val buttonlogin = findViewById<View>(R.id.tv_login)


        @Suppress("DEPRECATION")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                window.insetsController?.hide(WindowInsets.Type.statusBars())
            }
        }else{
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

       // setupActionBar()

            buttonlogin.setOnClickListener {
                val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
                startActivity(intent)

            }
    }
//    private fun setupActionBar(){
//        val toolbar_register_activity = (Toolbar) findViewById(R.id.ic_black);
//        setSupportActionBar(toolbar_register_activity)
//
//        val actionBar = supportActionBar
//        if(actionBar != null){
//            actionBar.setDisplayHomeAsUpEnabled(true)
//            actionBar.setHomeAsUpIndicator(R.drawable.ic_black_color_back_24dp)
//        }
//
//
//        toolbar_register_activity.setNavigationOnClickListener {onBackPressed()}
//
//    }

    // A function to validate Refister details of a new user



}
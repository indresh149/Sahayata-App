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
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import com.example.android.sahayata.MainActivity
import com.example.android.sahayata.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.Exception

class RegisterActivity : BaseActivity() {
    lateinit var regEmail: EditText
    lateinit var regName: EditText
    lateinit var regUniqueCode: EditText
    lateinit var regBattalionId: EditText
    lateinit var regPhone: EditText
    lateinit var mAuth: FirebaseAuth
    lateinit var fstore: FirebaseFirestore
    lateinit var progressBar: ProgressBar
    lateinit var regPassword: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        mAuth = FirebaseAuth.getInstance()
        fstore = FirebaseFirestore.getInstance()

        regEmail = findViewById(R.id.editTextEmailAddress)
        regName = findViewById(R.id.editTextPersonName)
//        regUniqueCode = findViewById(R.id.regUniqueCode)
        regBattalionId = findViewById(R.id.eregBattaialnId)
        regPhone = findViewById(R.id.regPhone)
        progressBar = findViewById(R.id.ProgressBar)
        regPassword = findViewById(R.id.regUniqueCode)


        //Firebase some auths intis


        val buttonlogin = findViewById<View>(R.id.tv_login)
        progressBar.isInvisible
//
//
//        @Suppress("DEPRECATION")
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                window.insetsController?.hide(WindowInsets.Type.statusBars())
//            }
//        }else{
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN
//            )
//        }

        // setupActionBar()

        buttonlogin.setOnClickListener {
//                val intent = Intent(this@RegisterActivity,LoginActivity::class.java)
//                startActivity(intent)

            registrationFun()

        }
    }

    private fun registrationFun() {
        progressBar.isVisible

        //init local vals
        var email: String
        var name: String
        var password: String
        var phone: String
        var batallianId: String


        //getting data from the xml
        email = regEmail.text.toString()
        name = regName.text.toString()
        password = regPassword.text.toString()
        phone = regPhone.text.toString()
        batallianId = regBattalionId.toString()


        //Function starting here for creating User
        try {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->

                if (task.isSuccessful) {
                    try {
                        Toast.makeText(this, "Welcome Soldier", Toast.LENGTH_SHORT).show()
                        val appUser: FirebaseUser = mAuth.currentUser!!
                        var df: DocumentReference =
                            fstore.collection("Soldier").document(appUser.uid)

                        //Uploading Soldier data in database with use of HashMap
                        var soldierInfo: HashMap<String, Any> = HashMap()
                        soldierInfo.put("UserEmail", email)
                        soldierInfo.put("UserName", name)
                        soldierInfo.put("UserPhone", phone)
                        soldierInfo.put("UserBattalianId", batallianId)

                        df.set(soldierInfo)

                        val regIntent = Intent(this, MainActivity::class.java)
                        progressBar.isGone
                        startActivity(regIntent)


                    } catch (e: Exception) {
                        Toast.makeText(this, "some error occur ", Toast.LENGTH_SHORT).show()
                    }
                }

            }

        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
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
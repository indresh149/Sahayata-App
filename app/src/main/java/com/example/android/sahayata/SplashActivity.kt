package com.example.android.sahayata


import android.app.PendingIntent.getActivity
import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.res.ResourcesCompat
import com.example.android.sahayata.activities.LoginActivity
import com.example.android.sahayata.activities.RegisterActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
//
//        @Suppress("DEPRECATION")
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
//                // for now i have changes hide to show status bar
//                window.insetsController?.show(WindowInsets.Type.statusBars())
//            }
//        }else{
//            window.setFlags(
//                WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN
//            )
//        }
//
        @Suppress("DEPRECATION")
        Handler().postDelayed(
            {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                finish()
            },
            3500
        )

        //  val typeface: Typeface = Typeface.createFromAsset(assets,"Mogata.ttf")
        //  tv_app_name.typeface = typeface

    }
}

private fun Handler.postDelayed(function: () -> Unit) {

}
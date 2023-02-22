package com.example.tracking.views.launch

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.tracking.R
import com.example.tracking.views.SignUpActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        initViews()
    }
    fun initViews(){
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
                finish()
//            overridePendingTransition(R.anim.slide_in_left, R.anim.fade_out)
        }, 500)
    }
}
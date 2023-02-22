package com.example.tracking.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.immortal.helpers.FormValidator
import com.example.tracking.Constants
import com.example.tracking.MainActivity
import com.example.tracking.R
import com.example.tracking.databinding.ActivityLoginBinding
import com.example.tracking.helpers.viewBinding

class LoginActivity : AppCompatActivity() {
    val binding by viewBinding (ActivityLoginBinding::inflate)
    val sharedPrefManager: com.example.tracking.manager.SharedPrefManager
        get() {
            return com.example.tracking.manager.SharedPrefManager.getInstance(this)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initViews()

    }
    fun initViews(){
        val email = sharedPrefManager.getPreference(Constants.EMAIL)
        val password = sharedPrefManager.getPreference(Constants.PASSWORD)
        binding.loginBtn.setOnClickListener{
            if (!FormValidator.requiredField(binding.userNameET.text.toString(), 1)) {
                Toast.makeText(this,"Mail is empty", Toast.LENGTH_SHORT).show()
            } else if (!FormValidator.requiredField(binding.passwordET.text.toString(), 1)) {
                Toast.makeText(this,"Password is empty", Toast.LENGTH_SHORT).show()
            } else if (!FormValidator.requiredField(binding.passwordET.text.toString(), 6)) {
                Toast.makeText(this,"Password should be more than 6 characters", Toast.LENGTH_SHORT).show()
            }
            else if(binding.userNameET.text.toString() == email && binding.passwordET.text.toString() ==password){
                sharedPrefManager.setPreference(Constants.IS_USER_LOGGED_IN,true)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Invalid Username or Password", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
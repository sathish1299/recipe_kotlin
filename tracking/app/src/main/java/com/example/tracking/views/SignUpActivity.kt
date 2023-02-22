package com.example.tracking.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.app.immortal.enums.ErrorMessageType
import com.app.immortal.helpers.FormValidator
import com.example.tracking.Constants
import com.example.tracking.R
import com.example.tracking.databinding.ActivitySignUpBinding
import com.example.tracking.helpers.viewBinding
import com.google.android.material.snackbar.Snackbar
import com.google.mlkit.common.sdkinternal.SharedPrefManager

class SignUpActivity : AppCompatActivity() {
    val binding by viewBinding(ActivitySignUpBinding::inflate)
    private var errorMsg: String? = null
       val sharedPrefManager: com.example.tracking.manager.SharedPrefManager
      get() {
            return com.example.tracking.manager.SharedPrefManager.getInstance(this)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        onClick()
    }
    fun onClick(){
        binding.register.setOnClickListener{
           if(initViews()) {
               val intent = Intent(this,LoginActivity::class.java)
               startActivity(intent)
           }else{
               showSnackbar(errorMsg)
           }
        }
    }

    fun initViews(): Boolean {
        var formOk = true

        if (!FormValidator.requiredField(binding.firstName.text.toString(), 1)) {
            formOk = false
            errorMsg = "Enter First Name"
        } else if (!FormValidator.requiredField(binding.lastName.text.toString(), 1)) {
            formOk = false
            errorMsg = "Enter Last Name"
        } else if (!FormValidator.requiredField(binding.email.text.toString(), 1)) {
            formOk = false
            errorMsg = "Enter the email"
        } else if (!FormValidator.validateEmail(binding.email.text.toString())) {
            formOk = false
            errorMsg = "Enter validate email"
        }
        else if (!FormValidator.requiredField(binding.passwords.text.toString(), 1)) {
            formOk = false
            errorMsg = "Enter the password"
        } else if (!FormValidator.requiredField(binding.passwords.text.toString(), 6)) {
            formOk = false
            errorMsg = "Passwords should be more than 6 characters"
        }
        else if (!FormValidator.requiredField(binding.confirmPass.text.toString(), 1)) {
            formOk = false
            errorMsg = "Enter the password"
        } else if (!FormValidator.requiredField(binding.confirmPass.text.toString(), 6)) {
            formOk = false
            errorMsg = "Passwords should be more than 6 characters"
        }
        else if (binding.passwords.text.toString()!=binding.confirmPass.text.toString()){
            formOk = false
            errorMsg = "Password and Confirm Password Should be same"
        }
        sharedPrefManager.setPreference(Constants.EMAIL,binding.email.text.toString())
        sharedPrefManager.setPreference(Constants.PASSWORD,binding.passwords.text.toString())
        return formOk
    }
    protected fun showSnackbar(
        message: String?,
        errorMessageType: ErrorMessageType = ErrorMessageType.snackbar
    ) {
        val snackbarMessage = SpannableStringBuilder(message)
        val snackbar = Snackbar.make(
            findViewById(android.R.id.content), snackbarMessage,
            Snackbar.LENGTH_LONG
        )
        snackbar.setDuration(2000)
        val snackBarView = snackbar.view
        var snackbarBg = R.color.black
        var snackbarTextColor = R.color.white
        if (errorMessageType == ErrorMessageType.snackbarError) {
            snackbarBg = R.color.black
            snackbarTextColor = R.color.white
        }

        snackBarView.setBackgroundColor(ContextCompat.getColor(this, snackbarBg))
        val textView =
            snackBarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        textView.maxLines = 4
        textView.setTextColor(ContextCompat.getColor(this, snackbarTextColor))
        snackbar.show()
    }

}
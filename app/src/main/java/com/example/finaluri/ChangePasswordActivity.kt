package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var passwordChangePassword1 : EditText
    private lateinit var passwordChangePassword2 : EditText
    private lateinit var Save : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)
        init()
        registerListeners()
        supportActionBar?.hide()
    }

    private fun init () {
        passwordChangePassword1 = findViewById(R.id.passwordChangePassword1)
        passwordChangePassword2 = findViewById(R.id.passwordChangePassword2)
        Save = findViewById(R.id.Save)
    }
    private fun registerListeners(){
        Save.setOnClickListener {
            val newPassword = passwordChangePassword1.text.toString()
            val confirmPassword = passwordChangePassword2.text.toString()
            if (newPassword.isEmpty() || confirmPassword.isEmpty()){
                passwordChangePassword1.error = "please enter your password"
                passwordChangePassword2.error = "please enter your password"
                return@setOnClickListener
            }
            if (newPassword.length < 9){
                passwordChangePassword1.error = "password must contain at least 9 characters"
                return@setOnClickListener
            }
            if (!newPassword.equals(confirmPassword)){
                passwordChangePassword2.error = "make sure the second password matches te first one"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "now you have new password", Toast.LENGTH_SHORT).show()
                    }else
                        Toast.makeText(this, "action failed", Toast.LENGTH_SHORT).show()
                }

        }
    }
}
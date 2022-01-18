package com.example.finaluri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var EmailReset : EditText
    private lateinit var Send : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)
        init()
        registerListeners()
        supportActionBar?.hide()
    }

    private fun init(){
        EmailReset = findViewById(R.id.EmailReset)
        Send = findViewById(R.id.Send)
    }

    private fun registerListeners(){
        Send.setOnClickListener{
            val email = EmailReset.text.toString()

            if (email.isEmpty()){
                EmailReset.error = "please enter your email"
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        Toast.makeText(this, "please check your email", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "action failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
package com.example.finaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var EmailAddress : EditText
    private lateinit var Password : EditText
    private lateinit var Login : Button
    private lateinit var Register : Button
    private lateinit var ForgotPassword : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        registerListeners()
        supportActionBar?.hide()
    }

    private fun init (){
        EmailAddress = findViewById(R.id.EmailAddress)
        Password = findViewById(R.id.Password)
        Login = findViewById(R.id.Login)
        Register = findViewById(R.id.Register)
        ForgotPassword = findViewById(R.id.ForgotPassword)
    }

    private fun registerListeners(){
       Register.setOnClickListener{
           val intent = Intent(this, RegisterActivity::class.java)
           startActivity(intent)
       }

       ForgotPassword.setOnClickListener{
           val intent = Intent(this, ResetPasswordActivity::class.java)
           startActivity(intent)
       }

       Login.setOnClickListener{
           val email = EmailAddress.text.toString()
           val passWord = Password.text.toString()

           if (email.isEmpty()){
               EmailAddress.error = "please enter your email"
               return@setOnClickListener
           }
           if (passWord.isEmpty()){
               Password.error = "please enter your password"
               return@setOnClickListener
           }

           FirebaseAuth.getInstance()
               .signInWithEmailAndPassword(email,passWord)
               .addOnCompleteListener{task ->
                   if (task.isSuccessful){
                       gotoProfile()
                   }else{
                       Toast.makeText(this, "action failed", Toast.LENGTH_SHORT).show()
                   }
               }


       }

    }

    private fun gotoProfile(){
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }

}
package com.example.finaluri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var Name : EditText
    private lateinit var LastName : EditText
    private lateinit var EmailRegister : EditText
    private lateinit var PasswordRegister : EditText
    private lateinit var RepeatPassword : EditText
    private lateinit var ButtonRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
        buttonRegister()
        supportActionBar?.hide()
    }

    private fun init(){
        Name = findViewById(R.id.Name)
        LastName = findViewById(R.id.LastName)
        EmailRegister = findViewById(R.id.EmailRegister)
        PasswordRegister = findViewById(R.id.PasswordRegister)
        RepeatPassword = findViewById(R.id.RepeatPassword)
        ButtonRegister = findViewById(R.id.ButtonRegister)

    }

    private fun buttonRegister() {
        ButtonRegister.setOnClickListener{
            val name = Name.text.toString()
            val lastname = LastName.text.toString()
            val registerEmail = EmailRegister.text.toString()
            val registerPassword = PasswordRegister.text.toString()
            val passwordRepeat = RepeatPassword.text.toString()

            if (name.isEmpty() || lastname.isEmpty() || registerEmail.isEmpty() ||
                registerPassword.isEmpty() || passwordRepeat.isEmpty()){
                Toast.makeText(this, "please, fill in the blanks", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else if (registerPassword.length < 9){
                PasswordRegister.error = "password must contain at least 9 characters"
                return@setOnClickListener
            }
            else if (!registerPassword.equals(passwordRepeat)){
                RepeatPassword.error = "make sure the second password matches the first one"
                return@setOnClickListener
            }

            FirebaseAuth.getInstance()
                .createUserWithEmailAndPassword(registerEmail,registerPassword)
                .addOnCompleteListener{task ->
                    if (task.isSuccessful){
                        val intent = Intent(this, LoginActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this, "action filed", Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }

}
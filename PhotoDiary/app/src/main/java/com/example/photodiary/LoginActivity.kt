package com.example.photodiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photodiary.databinding.ActivityLoginBinding
import com.example.photodiary.databinding.ActivityWelcomeBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var myBinding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        // NEED TO CHANGE THIS IN FUTURE
        myBinding.buttonLogin.setOnClickListener {
            val myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
        myBinding.buttomBackSignup.setOnClickListener {
            val myIntent = Intent(this, SignupActivity::class.java)
            startActivity(myIntent)
        }
    }
}
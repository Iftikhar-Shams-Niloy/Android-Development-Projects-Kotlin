package com.example.photodiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photodiary.databinding.ActivitySignupBinding
import com.example.photodiary.databinding.ActivityWelcomeBinding

class SignupActivity : AppCompatActivity() {

    private lateinit var myBinding : ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        // NEED TO CHANGE THIS IN FUTURE
        myBinding.buttonSignup.setOnClickListener{
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }

        myBinding.buttonBackLogin.setOnClickListener {
            val myIntent = Intent(this, LoginActivity::class.java)
            startActivity(myIntent)
        }

    }
}
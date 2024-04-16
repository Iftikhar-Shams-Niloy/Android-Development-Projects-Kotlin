package com.example.photodiary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photodiary.databinding.ActivityCreateNewBinding
import com.example.photodiary.databinding.ActivityMainBinding
import com.example.photodiary.databinding.ActivityStoryviewBinding

@Suppress("DEPRECATION")
class CreateNewActivity : AppCompatActivity() {
    private lateinit var myBinding: ActivityCreateNewBinding
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityCreateNewBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        myBinding.cardViewAddImage.setOnClickListener { pickImage() }

//        myBinding.cardViewAddTitle.setOnClickListener { pickTitle() }
    }

    private fun pickImage() {
        val imageIntent = Intent(Intent.ACTION_PICK)
        imageIntent.type = "image/*"
        startActivityForResult(imageIntent, IMAGE_REQUEST_CODE)
    }

//    private fun pickTitle() {
//        TODO("Necessary to code to change the Title")
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            myBinding.imageViewImageNew.setImageURI(data?.data)
        }
    }
}
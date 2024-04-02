package com.example.photodiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.photodiary.databinding.ActivityMainBinding
import com.example.photodiary.databinding.ActivityStoryviewBinding

class StoryviewActivity : AppCompatActivity() {

    lateinit var storyTitle : String
    lateinit var storyDescription : String
    var storyImage : Int = R.drawable.example_image
    var storyRating : Float = 0.0F
    lateinit var storyLocation : String

    lateinit var myBinding : ActivityStoryviewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityStoryviewBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        getIntentValues()
        setViews()
    }

    private fun getIntentValues() {
        storyTitle = intent.getStringExtra("storyTitle").toString()
        storyImage = intent.getIntExtra("storyImage", R.drawable.example_image)
        storyDescription = intent.getStringExtra("storyDescription").toString()
        storyLocation = intent.getStringExtra("storyLocation").toString()
        storyRating = intent.getFloatExtra("storyRating", 0.0F)
    }
    private fun setViews() {
        myBinding.imageViewImage.setImageResource(storyImage)
        myBinding.textViewStoryTitle.text = storyTitle
        myBinding.textViewDescription.text = storyDescription
        myBinding.ratingBarPersonal.rating = storyRating
        myBinding.textViewStoryLocation.text = storyLocation
    }

}
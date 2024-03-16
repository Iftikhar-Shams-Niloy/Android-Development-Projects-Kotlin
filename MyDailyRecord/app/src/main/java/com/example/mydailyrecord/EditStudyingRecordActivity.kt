package com.example.mydailyrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mydailyrecord.databinding.ActivityEditStudyingRecordBinding

class EditStudyingRecordActivity : AppCompatActivity() {

    private lateinit var binding : ActivityEditStudyingRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditStudyingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val studyTime = intent.getStringExtra("studyTime")
        title = "Study Time : $studyTime"
        binding.textViewStudyTimeHeader.setText("Study Time : $studyTime")

    }
}
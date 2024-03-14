package com.example.mydailyrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.commit
import com.example.mydailyrecord.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.frame_content, StudyingFragment())
        }

//        binding.bottomNav.setOnItemSelectedListener()

        binding.buttonStudy.setOnClickListener{onStudyClicked()}
        binding.buttonBreak.setOnClickListener{onBreakClicked()}
        binding.buttonStatus.setOnClickListener{onStatusClicked()}
    }

    private fun onStudyClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, StudyingFragment())
        }
    }

    private fun onBreakClicked(){
        supportFragmentManager.commit {
            replace(R.id.frame_content, BreakingFragment())
        }
    }

    private fun onStatusClicked(){
        supportFragmentManager.commit {
            replace(R.id.frame_content, StatusFragment())
        }
    }

}
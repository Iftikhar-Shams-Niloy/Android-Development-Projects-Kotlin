package com.example.mydailyrecord

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.commit
import com.example.mydailyrecord.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.commit {
            add(R.id.frame_content, StudyingFragment())
        }

//        binding.bottomNav.setOnNavigationItemSelectedListener()  <-- This is depricated insted use --> ".setOnItemSelectedListener()"
        binding.bottomNav.setOnItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.nav_study){
            onStudyClicked()
            return true
        } else if(item.itemId == R.id.nav_break){
            onBreakClicked()
            return true
        } else if(item.itemId == R.id.nav_status){
            onStatusClicked()
            return true
        } else {
            return false
        }
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
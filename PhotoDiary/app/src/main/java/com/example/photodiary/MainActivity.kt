package com.example.photodiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView.RecyclerListener
import android.widget.RatingBar
import androidx.fragment.app.commit
import androidx.recyclerview.widget.RecyclerView
import com.example.photodiary.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var myBinding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView
    lateinit var myRecylerView: RecyclerView
    lateinit var myArrayList: ArrayList<Story>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        myBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(myBinding.root)

        supportFragmentManager.commit {
            add(R.id.frame_content, AllviewFragment())
        }

        myBinding.bottomNav.setOnItemSelectedListener(this)

        ////////////////////////////////////////////////////////////////////////////////

        ////////////////////////////////////////////////////////////////////////////////

    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.nav_allview -> {onAllviewClicked(); true}
            R.id.nav_onlyphotos -> {onOnlyphotosClicked(); true}
            else -> false
        }
    }

    private fun onOnlyphotosClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, OnlyphotosFragment())
        }
    }
    private fun onAllviewClicked() {
        supportFragmentManager.commit {
            replace(R.id.frame_content, AllviewFragment())
        }
    }

}
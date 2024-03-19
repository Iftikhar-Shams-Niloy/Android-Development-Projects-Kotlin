package com.example.photodiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photodiary.databinding.FragmentAllviewBinding

class AllviewFragment : Fragment() {

    lateinit var storyTitleArray: ArrayList<String>
    lateinit var storyImageArray: ArrayList<Int>
    lateinit var storyDescriptionArray: ArrayList<String>
    lateinit var storyRatingArray: ArrayList<Float>
    lateinit var storyLocationArray: ArrayList<String>
    lateinit var myRecylerView: RecyclerView
    lateinit var myArrayList: ArrayList<Story>

    private lateinit var myBinding : FragmentAllviewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myBinding = FragmentAllviewBinding.inflate(inflater, container, false)
        return myBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val loremIpsum = "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum " +
                "loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum loremIpsum "

        storyTitleArray = arrayListOf("Iftikhar", "Shams", "Niloy")
        storyImageArray = arrayListOf(R.drawable.only_photo_logo, R.drawable.only_photo_logo, R.drawable.only_photo_logo)
        storyDescriptionArray = arrayListOf(loremIpsum, loremIpsum, loremIpsum)
        storyRatingArray = arrayListOf((2.5).toFloat(),(3.0).toFloat(),(4.5).toFloat())
        storyTitleArray = arrayListOf("My First Name", "My Middle Name", "My Last Name")
        storyLocationArray = arrayListOf("Mohammadpur", "Badda", "Jhenaidah")

        myRecylerView = myBinding.recyclerViewStory
        myRecylerView.layoutManager = LinearLayoutManager(context)
        myRecylerView.setHasFixedSize(true)
        myArrayList = arrayListOf<Story>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in storyTitleArray.indices){
            val newStory = Story(storyImageArray[i],storyTitleArray[i],storyDescriptionArray[i],storyRatingArray[i],storyLocationArray[i])
            myArrayList.add(newStory)
        }
        myRecylerView.adapter =  MyAdapter(myArrayList)
    }

}
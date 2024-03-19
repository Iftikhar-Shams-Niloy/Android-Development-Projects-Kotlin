package com.example.photodiary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.photodiary.databinding.FragmentAllviewBinding
import com.example.photodiary.databinding.FragmentOnlyphotosBinding

class OnlyphotosFragment : Fragment() {
    lateinit var storyTitleArray: ArrayList<String>
    lateinit var storyImageArray: ArrayList<Int>

    lateinit var myRecylerView: RecyclerView
    lateinit var myArrayList: ArrayList<Story>

    private lateinit var myBinding : FragmentOnlyphotosBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myBinding = FragmentOnlyphotosBinding.inflate(inflater, container, false)
        return myBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        storyImageArray = arrayListOf(R.drawable.only_photo_logo, R.drawable.only_photo_logo, R.drawable.only_photo_logo)
        storyTitleArray = arrayListOf("My First Name", "My Middle Name", "My Last Name")


        myRecylerView = myBinding.recyclerViewStoryImage
        myRecylerView.layoutManager = LinearLayoutManager(context)
        myRecylerView.setHasFixedSize(true)
        myArrayList = arrayListOf<Story>()
        getUserdata()

    }

    private fun getUserdata() {
        for (i in storyTitleArray.indices){
            val newStory = Story(storyImageArray[i],storyTitleArray[i],"null",(5).toFloat(),"null")
            myArrayList.add(newStory)
        }
        myRecylerView.adapter =  MyAdapter2(myArrayList)
    }


}
package com.example.photodiary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter2 (private val storyList:ArrayList<Story>) : RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = storyList[position]
        holder.storyImageAdapter.setImageResource(currentItem.storyImage)
        holder.storyTitleAdapter.setText(currentItem.storyTitle)
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val storyTitleAdapter: TextView = itemView.findViewById(R.id.text_view_title)
        val storyImageAdapter: ImageView = itemView.findViewById(R.id.image_view_story_image)
    }
}
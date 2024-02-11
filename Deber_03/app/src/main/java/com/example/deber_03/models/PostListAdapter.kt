package com.example.deber_03.models

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.deber_03.R

class PostListAdapter(private val itemList: List<PostItemModel>):
    RecyclerView.Adapter<PostListAdapter.ViewHolder>(){

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val namePost: TextView = itemView.findViewById(R.id.namePost)
        val datePost: TextView = itemView.findViewById(R.id.datePost)
        val iconPost: ImageView = itemView.findViewById(R.id.iconPost)
        val imgPost: ImageView = itemView.findViewById(R.id.imgPost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        Glide.with(holder.itemView.context)
            .load(currentItem.iconUrl)
            .apply(RequestOptions.circleCropTransform())

            .into(holder.iconPost)
        holder.namePost.text = currentItem.name

        holder.datePost.text = currentItem.time.toString()

        Glide.with(holder.itemView.context)
            .load(currentItem.imgUrl)
            .into(holder.imgPost)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}
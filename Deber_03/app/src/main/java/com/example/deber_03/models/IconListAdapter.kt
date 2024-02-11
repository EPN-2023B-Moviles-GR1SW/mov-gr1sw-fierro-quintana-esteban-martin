package com.example.deber_03.models

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.deber_03.R

class IconListAdapter(private val itemList: List<MsgItemModel>) :
    RecyclerView.Adapter<IconListAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgIcon: ImageView = itemView.findViewById(R.id.imgIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.icon_item_layout, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        Glide.with(holder.itemView.context)
            .load(currentItem.imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.imgIcon)
    }
    override fun getItemCount(): Int {
        return itemList.size
    }
}
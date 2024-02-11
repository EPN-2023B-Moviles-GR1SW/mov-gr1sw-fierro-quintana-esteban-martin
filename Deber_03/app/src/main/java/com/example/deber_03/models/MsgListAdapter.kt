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

class MsgListAdapter(private val itemList: List<MsgItemModel>) :
    RecyclerView.Adapter<MsgListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        val tv_description: TextView = itemView.findViewById(R.id.tv_description)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        // Agrega más vistas según sea necesario
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.msg_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]

        Glide.with(holder.itemView.context)
            .load(currentItem.imageUrl)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.imageView)
        holder.titleTextView.text = currentItem.name
        holder.tv_description.text = currentItem.description
        // Vincula más datos a las vistas según sea necesario
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}


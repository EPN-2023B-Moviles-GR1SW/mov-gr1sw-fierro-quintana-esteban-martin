package com.example.deber_03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MsgListAdapter(private val itemList: List<MsgItemModel>) :
    RecyclerView.Adapter<MsgListAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        val tv1: TextView = itemView.findViewById(R.id.tv_1)
        // Agrega más vistas según sea necesario
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.msg_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = itemList[position]
        println(currentItem)
        holder.titleTextView.text = currentItem.title
        holder.tv1.text = currentItem.title
        // Vincula más datos a las vistas según sea necesario
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}


package com.example.examenmov

import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SectionAdapter (private val sections: List<Section>) : RecyclerView.Adapter<SectionAdapter.SectionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SectionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.section_item, parent, false)
        return SectionViewHolder(view)
    }

    override fun onBindViewHolder(holder: SectionViewHolder, position: Int) {
        val section = sections[position]
        holder.bind(section)
    }

    override fun getItemCount(): Int = sections.size

    class SectionViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titleTextView: TextView = view.findViewById(R.id.sectionTitle)
        private val itemsRecyclerView: RecyclerView = view.findViewById(R.id.itemsRecyclerView)

        fun bind(section: Section) {
            val spannable = SpannableString(section.title)
            if (section.title.startsWith("Prime ")) {
                spannable.setSpan(
                    ForegroundColorSpan(ContextCompat.getColor(itemView.context, R.color.items)),
                    0,
                    5,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
                )
            }

            titleTextView.text = spannable

            itemsRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
            itemsRecyclerView.adapter = CarouselAdapter(section.items)
        }
    }
}
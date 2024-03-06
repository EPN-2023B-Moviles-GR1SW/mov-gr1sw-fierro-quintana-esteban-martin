package com.example.examenmov

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BusquedaProgramAdapter(private val programsList: List<Program>) : RecyclerView.Adapter<BusquedaProgramAdapter.ProgramViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgramViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_busqueda, parent, false)
        return ProgramViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProgramViewHolder, position: Int) {
        val currentItem = programsList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount() = programsList.size

    class ProgramViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.imageViewProgram)
        private val titleTextView: TextView = itemView.findViewById(R.id.textViewTitle)
        private val yearTextView: TextView = itemView.findViewById(R.id.textViewYear)

        fun bind(program: Program) {

            imageView.setImageResource(program.imageUrl) // Si es un drawable
            titleTextView.text = program.title
            yearTextView.text = program.anio.toString()
        }
    }
}
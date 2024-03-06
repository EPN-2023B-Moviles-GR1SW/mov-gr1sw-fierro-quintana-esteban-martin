package com.example.examenmov

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CalificacionesAdapter(private val listaCalificaciones: MutableList<Calificacion>) : RecyclerView.Adapter<CalificacionesAdapter.CalificacionViewHolder>() {
    class CalificacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(calificacion: Calificacion) {
            itemView.findViewById<TextView>(R.id.textViewNombre).text = calificacion.nombre
            itemView.findViewById<TextView>(R.id.textViewDescripcion).text = calificacion.descripcion
            itemView.findViewById<TextView>(R.id.textViewCalificacion).text = calificacion.calificacion.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalificacionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_calificacion, parent, false)
        return CalificacionViewHolder(view)
    }


    override fun onBindViewHolder(holder: CalificacionViewHolder, position: Int) {
        holder.bind(listaCalificaciones[position])
    }

    override fun getItemCount() = listaCalificaciones.size

    fun actualizarCalificaciones(nuevasCalificaciones: List<Calificacion>) {
        listaCalificaciones.clear()
        listaCalificaciones.addAll(nuevasCalificaciones)
        notifyDataSetChanged()
    }
}

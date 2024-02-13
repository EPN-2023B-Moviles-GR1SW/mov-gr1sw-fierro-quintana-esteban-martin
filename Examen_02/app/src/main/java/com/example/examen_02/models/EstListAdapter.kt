package com.example.examen_02.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.examen_02.R

class EstListAdapter(private val context: Context, private val datos: MutableMap<String, Estudiante>):
    BaseAdapter() {

    override fun getCount(): Int {
        return datos.size
    }

    // Retorna el objeto en la posición especificada en tu conjunto de datos
    override fun getItem(position: Int): Estudiante? {
        // Convertir el mapa a una lista de claves y acceder al elemento por posición
        val keys = datos.keys.toList()
        return datos[keys[position]]
    }

    // Retorna el ID asociado con el objeto en la posición especificada
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Crea y retorna una vista para cada elemento en el conjunto de datos
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        if (vista == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            vista = inflater.inflate(R.layout.est_item_layout, null)
        }

        // Personaliza la vista con los datos del elemento en la posición actual
        val tv_nombre = vista?.findViewById<TextView>(R.id.tv_nombre)
        val tv_apellido = vista?.findViewById<TextView>(R.id.tv_apellido)

        val estudiante = getItem(position)
        tv_nombre?.text = estudiante?.nombre
        tv_apellido?.text = estudiante?.apellido

        return vista!!
    }
}
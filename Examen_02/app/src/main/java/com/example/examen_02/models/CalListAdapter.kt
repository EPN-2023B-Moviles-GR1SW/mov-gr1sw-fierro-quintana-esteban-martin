package com.example.examen_02.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.examen_02.R

class CalListAdapter(private val context: Context, private val datos: MutableList<Calificacion>):
    BaseAdapter() {
    override fun getCount(): Int {
        return datos.size
    }

    // Retorna el objeto en la posición especificada en tu conjunto de datos
    override fun getItem(position: Int): Calificacion? {
        return datos[position]
    }

    // Retorna el ID asociado con el objeto en la posición especificada
    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    // Crea y retorna una vista para cada elemento en el conjunto de datos
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var vista = convertView
        if (vista == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            vista = inflater.inflate(R.layout.cal_item_layout, null)
        }

        // Personaliza la vista con los datos del elemento en la posición actual
        val tv_nota = vista?.findViewById<TextView>(R.id.tv_nota)
        val tv_materia = vista?.findViewById<TextView>(R.id.tv_materia)
        val tv_sipasa = vista?.findViewById<TextView>(R.id.tv_sipasa)
        tv_materia?.text = "${datos[position]?.materia.toString()}:"
        tv_nota?.text = datos[position]?.valor.toString()
        if (datos[position]?.pasa == true){
            tv_sipasa?.text = "Pasa"
        }else{
            tv_sipasa?.text = "No Pasa"
        }

        return vista!!
    }
}
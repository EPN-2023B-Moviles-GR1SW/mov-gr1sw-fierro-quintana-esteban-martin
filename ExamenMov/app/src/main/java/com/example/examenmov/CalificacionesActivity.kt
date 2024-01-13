package com.example.examenmov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import com.example.examen.models.Calificacion
import com.example.examen.models.CustomBaseAdapter
import com.example.examen.models.ManejadorEstudiante
import com.example.examenmov.models.BaseAdaptarCal

class CalificacionesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calificaciones)

        initProgram()

    }

    fun initProgram(){
        val tvResult = findViewById<TextView>(R.id.tv_est)

        val id: Int? = intent.extras?.getInt("id")

        val lista = ManejadorEstudiante.obtenerLista()


        val nombre = lista[id]?.nombre
        val apellido = lista[id]?.apellido

        //val id: String = intent.extras?.getString("id").orEmpty()
        tvResult.text = "$nombre $apellido"

        val calificaciones:MutableList<Calificacion>? = lista[id]?.obtenerCalificaciones()
        Log.i("cal", calificaciones.toString())

        if(calificaciones?.isNotEmpty() == true){
            val adaptadorCal = calificaciones?.let { BaseAdaptarCal(this, it) }
            val lv2 = findViewById<ListView>(R.id.lv_cal)
            lv2.adapter = adaptadorCal

            lv2.setOnItemClickListener { _, view, position, _ ->

                // Obtén la vista del ícono del menú
                val menuIcon = view.findViewById<androidx.cardview.widget.CardView>(R.id.cv_nota)
                // Muestra el menú contextual
                showPopupMenu(menuIcon, position)
            }
        }else{
            val tv_exep = findViewById<TextView>(R.id.tv_exep)
            tv_exep.text = "No tiene calificaciones"
        }

        val btnNuevaNota = findViewById<Button>(R.id.btn_nueva_cal)
        btnNuevaNota.setOnClickListener {
            val intend = Intent(this, CrearNotaActivity::class.java)
            intend.putExtra("id", id)
            startActivity(intend)
        }
    }
    fun showPopupMenu(view: View, position: Int) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.menu_calificaciones)

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.opc1-> {
                    Toast.makeText(this, "Estudiante as", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.opc2 -> {
                    Toast.makeText(this, "Estudiante Eliminado", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> false
            }
        }
        popupMenu.show()
    }
}
package com.example.examen_02

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
import com.example.examen_02.models.CalListAdapter
import com.example.examen_02.models.Calificacion
import com.example.examen_02.models.EstHandlerList
import com.example.examen_02.models.Estudiante

class CalListActivity : AppCompatActivity() {

    var id: Int? = null
    private val lista = EstHandlerList.obtenerLista()
    var calificaciones:MutableList<Calificacion>? = null
    lateinit var est : Estudiante
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal_list)
        initProgram()
    }
    fun initProgram(){
        val tvResult = findViewById<TextView>(R.id.tv_est)

        id = intent.extras?.getInt("id")
        est = lista[id]!!


        val nombre = lista[id]?.nombre
        val apellido = lista[id]?.apellido

        //val id: String = intent.extras?.getString("id").orEmpty()
        tvResult.text = "$nombre $apellido"

        calificaciones= lista[id]?.obtenerCalificaciones()
        Log.i("cal", calificaciones.toString())

        if(calificaciones?.isNotEmpty() == true){
            val adaptadorCal = calificaciones?.let { CalListAdapter(this, it) }
            val lv2 = findViewById<ListView>(R.id.lv_cal)
            lv2.adapter = adaptadorCal

            lv2.setOnItemClickListener { _, view, position, _ ->

                // Obtén la vista del ícono del menú
                val menuIcon = view.findViewById<androidx.cardview.widget.CardView>(R.id.cv_nota)
                // Muestra el menú contextual
                if (adaptadorCal != null) {
                    showPopupMenu(menuIcon, position, adaptadorCal)
                }
            }
        }else{
            val tv_exep = findViewById<TextView>(R.id.tv_exep)
            tv_exep.text = "No tiene calificaciones"
        }

        val btnNuevaNota = findViewById<Button>(R.id.btn_nueva_cal)
        btnNuevaNota.setOnClickListener {
            val intend = Intent(this, AddCalFormActivity::class.java)
            intend.putExtra("id", id)
            startActivity(intend)
        }
    }

    fun showPopupMenu(view: View, position: Int, adapter:CalListAdapter) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.cal_item_menu)

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.opc1-> {
                    val intend = Intent(this, EditCalFormActivity::class.java)
                    intend.putExtra("id", id)
                    intend.putExtra("index", position)
                    startActivity(intend)

                    true
                }

                R.id.opc2 -> {
                    calificaciones?.get(position)?.let { est.eliminarCalificacion(it.materia) }
                    Toast.makeText(this, "Calificacion Eliminado", Toast.LENGTH_SHORT).show()
                    adapter.notifyDataSetChanged()
                    true
                }

                else -> false
            }
        }
        popupMenu.show()
    }
}
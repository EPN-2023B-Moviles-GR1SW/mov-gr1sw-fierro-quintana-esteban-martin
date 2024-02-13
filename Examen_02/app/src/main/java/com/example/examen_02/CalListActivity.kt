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

    var id: String? = null
    private val lista = EstHandlerList.obtenerLista()
    var calificaciones:MutableList<Calificacion>? = null
    lateinit var estudiante : Estudiante
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cal_list)
        initProgram()
        initBtnNewNote()
        initBtnUpdateList()
    }
    fun initProgram(){
        val tvResult = findViewById<TextView>(R.id.tv_est)
        id = intent.extras?.getString("StringId")
        estudiante = lista[id]!!
        val nombre = estudiante.nombre
        val apellido = estudiante.apellido
        tvResult.text = "$nombre $apellido"

    }
    fun initBtnNewNote(){
        val btnNuevaNota = findViewById<Button>(R.id.btn_nueva_cal)
        btnNuevaNota.setOnClickListener {
            val intend = Intent(this, AddCalFormActivity::class.java)
            intend.putExtra("StringId", id)
            startActivity(intend)
        }
    }
    fun initBtnUpdateList(){
        val btnUpdateList = findViewById<Button>(R.id.btn_update_cal_list)
        btnUpdateList.setOnClickListener {
            initList()
        }
    }

    fun initList(){
        estudiante.actualizarCalificaciones(id!!)

        calificaciones= estudiante.obtenerCalificaciones()
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
            adaptadorCal!!.notifyDataSetChanged()
        }else{
            val tv_exep = findViewById<TextView>(R.id.tv_exep)
            tv_exep.text = "No tiene calificaciones"
        }

    }

    fun showPopupMenu(view: View, position: Int, adapter:CalListAdapter) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.cal_item_menu)

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.opc1-> {
                    val intend = Intent(this, EditCalFormActivity::class.java)
                    intend.putExtra("EstId", id)
                    intend.putExtra("index", position)
                    intend.putExtra("calId", estudiante.obtenerIdLista(position))
                    startActivity(intend)

                    true
                }

                R.id.opc2 -> {
                    calificaciones?.get(position)?.let {
                        estudiante.eliminarCalificacion(
                            id!!,
                            estudiante.obtenerIdLista(position)
                        ) }
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
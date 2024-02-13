package com.example.examen_02

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen_02.models.EstHandlerList
import com.example.examen_02.models.EstListAdapter
import com.example.examen_02.models.Estudiante
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    var lista_estudiantes: MutableMap<String, Estudiante> = mutableMapOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initProgram()
    }

    override fun onResume() {
        super.onResume()
        initProgram()
    }

    fun initProgram() {
        initAddStudentButton()
        initUpdateListBtn()
    }

    fun initList() {
        EstHandlerList.actualizarLista()
        lista_estudiantes= EstHandlerList.listaEstudiantes
        initListComponents()
    }
    fun initListComponents(){
        //Thread.sleep(2000);
        val lvStudentList = findViewById<ListView>(R.id.lv_student_list)
        val miadapter = EstListAdapter(this, lista_estudiantes)

        lvStudentList.adapter = miadapter
        lvStudentList.setOnItemClickListener { _, view, position, _ ->
            // Obtén la vista del ícono del menú
            val menuIcon = view.findViewById<androidx.cardview.widget.CardView>(R.id.cv_item)
            // Muestra el menú contextual
            showPopupMenu(menuIcon, position, miadapter)
        }
        miadapter.notifyDataSetChanged()
    }
    fun initUpdateListBtn(){
        val btnActualizarLista = findViewById<Button>(R.id.btn_update_list)

        btnActualizarLista.setOnClickListener {
            initList()
        }
    }

    fun initAddStudentButton() {
        val btnCrearEstudiante = findViewById<Button>(R.id.btn_add_student)

        btnCrearEstudiante.setOnClickListener {
            val intend = Intent(this, AddEstFormActivity::class.java)
            startActivity(intend)

        }

    }

    fun showPopupMenu(view: View, position: Int, miadapter: EstListAdapter) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.est_item_menu)

        popupMenu.setOnMenuItemClickListener { menuItem: MenuItem ->
            when (menuItem.itemId) {
                R.id.opcion1 -> {
                    println(position)
                    val intend = Intent(this, EditEstFormActivity::class.java)
                    intend.putExtra("StringId", EstHandlerList.obtenerIdLista(position))
                    startActivity(intend)
                    true
                }

                R.id.opcion2 -> {
                    val intend = Intent(this, CalListActivity::class.java)
                    intend.putExtra("StringId", EstHandlerList.obtenerIdLista(position))
                    startActivity(intend)
                    true
                }

                R.id.opcion3 -> {
                    EstHandlerList.eliminarEstudiante(EstHandlerList.obtenerIdLista(position))
                    Toast.makeText(this, "Estudiante Eliminado", Toast.LENGTH_SHORT).show()
                    miadapter.notifyDataSetChanged()
                    true
                }

                else -> false
            }
        }

        popupMenu.show()
    }

}
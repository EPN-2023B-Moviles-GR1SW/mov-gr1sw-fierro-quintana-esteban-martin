package com.example.examen_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.examen_02.models.EstHandlerList
import com.google.android.material.textfield.TextInputEditText

class EditCalFormActivity : AppCompatActivity() {

    lateinit var inputValor: TextInputEditText
    lateinit var inputMateria: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_cal_form)

        val btnEditar = findViewById<Button>(R.id.btn_editar_nota)
        obtenerDatos()
        btnEditar.setOnClickListener {
            logicaEditar()
        }
    }
    fun obtenerDatos(){
        val id: Int = intent.extras?.getInt("id")!!
        val index: Int = intent.extras?.getInt("index")!!
        inputValor = findViewById(R.id.input_valor)
        inputMateria = findViewById(R.id.input_materia)
        val lista = EstHandlerList.obtenerLista()
        var estudiante = lista[id]
        if (estudiante != null) {
            inputValor.setText(estudiante!!.calificaciones[index].valor.toString())
            inputMateria.setText(estudiante!!.calificaciones[index].materia)
        }
    }
    fun logicaEditar(){
        val id: Int = intent.extras?.getInt("id")!!
        val index: Int = intent.extras?.getInt("index")!!
        val lista = EstHandlerList.obtenerLista()
        var estudiante = lista[id]


        val inputNota:String = inputValor.text.toString()
        var numero: Double = 0.0
        val materia = inputMateria.text.toString()



        try {
            numero= inputNota.toDoubleOrNull()!!

            if (numero != null) {
                estudiante?.editarCalificacion(index,materia, numero)
                Toast.makeText(this," Nota Editada", Toast.LENGTH_SHORT).show()
                val intend = Intent(this, MainActivity::class.java)
                startActivity(intend)
            }
        } catch (e: NumberFormatException) {
            println(e)
        }

    }
}
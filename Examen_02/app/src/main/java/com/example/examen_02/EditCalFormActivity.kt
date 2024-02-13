package com.example.examen_02

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen_02.models.EstHandlerList
import com.google.android.material.textfield.TextInputEditText

class EditCalFormActivity : AppCompatActivity() {

    val lista = EstHandlerList.obtenerLista()
    lateinit var inputValor: TextInputEditText
    lateinit var inputMateria: TextInputEditText
    lateinit var id: String
    private var index: Int = 0
    var calID: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_cal_form)

        val btnEditar = findViewById<Button>(R.id.btn_editar_nota)
        obtenerDatos()
        btnEditar.setOnClickListener {
            logicaEditar()
        }
    }

    fun obtenerDatos() {
        id = intent.extras?.getString("EstId")!!
        index = intent.extras?.getInt("index")!!
        calID = intent.extras?.getString("calId")!!
        inputValor = findViewById(R.id.input_valor)
        inputMateria = findViewById(R.id.input_materia)

        var estudiante = lista[id]
        if (estudiante != null) {
            inputValor.setText(estudiante!!.calificaciones[index].valor.toString())
            inputMateria.setText(estudiante!!.calificaciones[index].materia)
        }
    }

    fun logicaEditar() {
        id = intent.extras?.getString("EstId")!!
        index = intent.extras?.getInt("index")!!
        calID = intent.extras?.getString("calId")!!

        var estudiante = lista[id]


        val inputNota: String = inputValor.text.toString()
        var numero: Double = 0.0
        val materia = inputMateria.text.toString()

        try {
            numero = inputNota.toDoubleOrNull()!!

            if (numero != null) {
                estudiante?.editarCalificacion(materia, numero, id, calID)
                Toast.makeText(this, " Nota Editada", Toast.LENGTH_SHORT).show()
                val intend = Intent(this, MainActivity::class.java)
                startActivity(intend)
            }
        } catch (e: NumberFormatException) {
            println(e)
        }

    }
}
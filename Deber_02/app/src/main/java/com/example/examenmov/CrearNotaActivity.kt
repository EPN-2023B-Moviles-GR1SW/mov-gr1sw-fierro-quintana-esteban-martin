package com.example.examenmov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.examen.models.ManejadorEstudiante
import com.google.android.material.textfield.TextInputEditText

class CrearNotaActivity : AppCompatActivity() {

    lateinit var inputValor: TextInputEditText
    lateinit var inputMateria: TextInputEditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_nota)

        val btnCrear = findViewById<Button>(R.id.btn_crear_nota)
        obtenerDatos()
        btnCrear.setOnClickListener {
            logicaCrear()
        }

    }

    fun obtenerDatos(){
        inputValor = findViewById(R.id.input_valor)
        inputMateria = findViewById(R.id.input_materia)
    }
    fun logicaCrear(){
        val id: Int = intent.extras?.getInt("id")!!

        val lista = ManejadorEstudiante.obtenerLista()

        val inputNota:String = inputValor.text.toString()
        var numero: Double = 0.0
        val materia = inputMateria.text.toString()
        var codMat: Int = 0


        try {
            numero= inputNota.toDoubleOrNull()!!

            if (numero != null) {
                lista[id]?.agregarCalificacion(numero, materia)
                Toast.makeText(this," Nota Creada", Toast.LENGTH_SHORT).show()
                val intend = Intent(this, MainActivity::class.java)
                startActivity(intend)
            }
        } catch (e: NumberFormatException) {
            println(e)
        }

    }
}
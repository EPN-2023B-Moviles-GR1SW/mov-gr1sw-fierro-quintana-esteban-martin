package com.example.examen_02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.examen_02.models.EstHandlerList
import com.google.android.material.textfield.TextInputEditText
import java.lang.Exception

class EditEstFormActivity : AppCompatActivity() {

    lateinit var inputNombre: TextInputEditText
    lateinit var inputApellido: TextInputEditText
    lateinit var inputCurso: TextInputEditText
    lateinit var inputParalelo: TextInputEditText
    lateinit var inputDiaCum: TextInputEditText

    var id: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_est_form)

        id = intent.extras?.getString("StringId")!!
        ponerDatos()

        val btnEditar = findViewById<Button>(R.id.btn_editar)
        btnEditar.setOnClickListener {
            if(verificarDatos()){
                try {
                    EstHandlerList.editarEstudiante(id,
                        inputNombre.text.toString(),
                        inputApellido.text.toString(),
                    )
                }catch (e: Exception){
                    println(e)
                }

                Toast.makeText(this, "Estudiante Editado Correctamente", Toast.LENGTH_SHORT).show()
                val intend = Intent(this, MainActivity::class.java)
                startActivity(intend)
            }else{
                Toast.makeText(this, "Complete los datos", Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun ponerDatos(){
        inputNombre= findViewById(R.id.input_nombre)
        inputApellido = findViewById(R.id.input_apellido)
        inputCurso = findViewById(R.id.input_curso)
        inputParalelo = findViewById(R.id.input_paralelo)
        inputDiaCum = findViewById(R.id.input_cumple)

        val lista = EstHandlerList.obtenerLista()
        inputNombre.setText(lista[id]!!.nombre)
        inputApellido.setText(lista[id]!!.apellido)
        lista[id]!!.curso?.let { inputCurso.setText(it) }
        inputParalelo.setText(lista[id]!!.paralelo)
        lista[id]!!.diaCumpleanos?.let { inputDiaCum.setText(it) }

    }
    fun verificarDatos(): Boolean {
        if (inputNombre.text?.isEmpty() == true || inputApellido.text?.isEmpty() == true)
        {
            val inputLayout = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.layout_nombre)
            inputLayout.error = "Este campo es obligatorio"
            val inputLayout2 = findViewById<com.google.android.material.textfield.TextInputLayout>(R.id.layout_apellido)
            inputLayout2.error = "Este campo es obligatorio"
            return false
        }else{
            return true
        }
    }

}
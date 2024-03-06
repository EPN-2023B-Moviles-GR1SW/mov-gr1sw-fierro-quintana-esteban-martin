package com.example.examenmov

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examenmov.ui.theme.ExamenMovTheme
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class UsuarioActivity : ComponentActivity() {

    val calificaciones = mutableListOf<Calificacion>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.usuario_activity)
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.selectedItemId = R.id.navigation_dashboard
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intend = Intent(this, MainActivity::class.java)
                    startActivity(intend)
                    true
                }
                R.id.navigation_notifications -> {
                    val intend = Intent(this, BusquedaActivity::class.java)
                    startActivity(intend)
                    true
                }
                else -> false
            }
        }
        val recyclerView = findViewById<RecyclerView>(R.id.namesList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CalificacionesAdapter(calificaciones)
        recyclerView.adapter = adapter
        initProgram()
    }

    fun initProgram() {
        lifecycleScope.launch {
            try {
                val lista = ManejadorCalificaciones.obtenerListaCalificaciones()
                // Actualización a la UI debe hacerse en el hilo principal
                runOnUiThread {
                    // Utiliza el nuevo método actualizarCalificaciones para actualizar los datos
                    (findViewById<RecyclerView>(R.id.namesList).adapter as? CalificacionesAdapter)?.actualizarCalificaciones(lista)
                }
            } catch (e: Exception) {
                println("Error al obtener las calificaciones: $e")
            }
        }
    }



}

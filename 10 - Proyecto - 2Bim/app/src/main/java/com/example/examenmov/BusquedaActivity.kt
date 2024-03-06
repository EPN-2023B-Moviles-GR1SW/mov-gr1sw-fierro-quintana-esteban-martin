package com.example.examenmov

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class BusquedaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda)

        val programsList = listOf(
            Program(
                id = "1",
                imageUrl = R.drawable.naruto,
                title = "Naruto Ninja Storm",
                description = "Gran juego de acción, enérgico y emocionante.",
                rating = 8.8,
                genre = "Peleas/Acción",
                anio = 2024
            ),
            Program(
                id = "2",
                imageUrl = R.drawable.dragonballz,
                title = "Dragon Ball Xenoverse 2",
                description = "Salva al multiverso de Dragon Ball del rompimiento de la línea temporal.",
                rating = 8.7,
                genre = "Peleas/Acción",
                anio = 2010
            ),
            Program(
                id = "3",
                imageUrl = R.drawable.tekken8,
                title = "Tekken 8",
                description = "Golpea, defiendete y sobrepasa el poder de tus enemigos.",
                rating = 8.8,
                genre = "Peleas/Acción",
                anio = 2024
            ),
            Program(
                id = "4",
                imageUrl = R.drawable.mortalkombat,
                title = "Mortal Kombat",
                description = "Frenético, agresivo y entretenido juego de peleas.",
                rating = 8.7,
                genre = "Acción/Luchas",
                anio = 2010
            ),
            Program(
                id = "5",
                imageUrl = R.drawable.papermarioorigami,
                title = "Paper Mario Origami",
                description = "Salva al reino champiñón en esta entretenida aventura estratégica.",
                rating = 8.7,
                genre = "Aventura/Estrategia",
                anio = 2024
            ),
            Program(
                id = "6",
                imageUrl = R.drawable.earthbound,
                title = "Earthbound",
                description = "Uno de los más icónicos juegos de nintendo por su historia y divertidos personajes.",
                rating = 8.7,
                genre = "Terror",
                anio = 2010
            ),
            Program(
                id = "7",
                imageUrl = R.drawable.persona3reload,
                title = "Persona 3 Reload",
                description = "Un RPG donde se sentirá el sentido de la vida y el temor a la muerte.",
                rating = 8.8,
                genre = "RPG/Colegial",
                anio = 2024
            ),
            Program(
                id = "8",
                imageUrl = R.drawable.pokemonescarlata,
                title = "Pokemon Escarlata",
                description = "Vuélvete un maestro pokemon en la emocionante región de Paldea.",
                rating = 8.7,
                genre = "Aventura/Exploración",
                anio = 2022
            ),
            )

        val recyclerView: RecyclerView = findViewById(R.id.programsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = BusquedaProgramAdapter(programsList)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.selectedItemId = R.id.navigation_notifications
        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    val intend = Intent(this, MainActivity::class.java)
                    startActivity(intend)
                    true
                }
                R.id.navigation_dashboard -> {
                    val intend = Intent(this, UsuarioActivity::class.java)
                    startActivity(intend)
                    true
                }
                else -> false
            }
        }
    }
}
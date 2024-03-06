package com.example.examenmov

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.contagion2,
            R.drawable.xfiles,
            R.drawable.barbie
        )

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val adapter2 = ImageSliderAdapter(images)
        val viewPager: ViewPager2 = findViewById(R.id.viewPagerImages)
        viewPager.adapter = adapter2

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        navView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_dashboard -> {
                    val intend = Intent(this, UsuarioActivity::class.java)
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

        val sectionsRecyclerView: RecyclerView = findViewById(R.id.sectionsRecyclerView)
        sectionsRecyclerView.layoutManager = LinearLayoutManager(this)

        val sections = listOf(
            Section(
                title = "Nuevos Lanzamientos",
                items = listOf(
                    Program(
                        id = "1",
                        imageUrl = R.drawable.palworld,
                        title = "Palworld",
                        description = "Un pokemon totalmente armado.",
                        rating = 8.6,
                        genre = "Aventura",
                        anio = 2024
                    ),
                    Program(
                        id = "2",
                        imageUrl = R.drawable.persona3reload,
                        title = "Persona 3 Reload",
                        description = "Un RPG donde se sentirá el sentido de la vida y el temor a la muerte.",
                        rating = 8.8,
                        genre = "RPG/Colegial",
                        anio = 2024
                    ),
                    Program(
                        id = "3",
                        imageUrl = R.drawable.naruto,
                        title = "Naruto Ninja Storm",
                        description = "Gran juego de acción, enérgico y emocionante.",
                        rating = 8.8,
                        genre = "Acción",
                        anio = 2024
                    ),
                    Program(
                        id = "4",
                        imageUrl = R.drawable.invincible,
                        title = "Invincible Guarding The Globe",
                        description = "Sé el más fuerte del mundo en este juego de estrategia.",
                        rating = 8.8,
                        genre = "Estrategia",
                        anio = 2024
                    ),
                    Program(
                        id = "5",
                        imageUrl = R.drawable.tekken8,
                        title = "Tekken 8",
                        description = "Golpea, defiendete y sobrepasa el poder de tus enemigos.",
                        rating = 8.8,
                        genre = "Acción",
                        anio = 2024
                    )
                )
            ),
            Section(
                title = "Exclusivos de Nintendo",
                items = listOf(
                    Program(
                        id = "1",
                        imageUrl = R.drawable.zbotw,
                        title = "Zelda Breath Of The Wild",
                        description = "Salva al reino de Hyrule del inminente despertar de Ganondorf.",
                        rating = 8.7,
                        genre = "Acción/Aventura",
                        anio = 2020
                    ),
                    Program(
                        id = "2",
                        imageUrl = R.drawable.pokemonescarlata,
                        title = "Pokemon Escarlata",
                        description = "Vuélvete un maestro pokemon en la emocionante región de Paldea.",
                        rating = 8.7,
                        genre = "Aventura/Exploración",
                        anio = 2022
                    ),
                    Program(
                        id = "3",
                        imageUrl = R.drawable.papermarioorigami,
                        title = "Paper Mario Origami",
                        description = "Salva al reino champiñón en esta entretenida aventura estratégica.",
                        rating = 8.7,
                        genre = "Aventura/Estrategia",
                        anio = 2024
                    ),
                    Program(
                        id = "4",
                        imageUrl = R.drawable.splatoon3,
                        title = "Splatoon 3",
                        description = "Domina tu territorio llenandolo de pintura con el entretenido repertorio de personajes que este juego tiene para ofrecer",
                        rating = 8.7,
                        genre = "Caricatura/FPS",
                        anio = 2022
                    ),
                    Program(
                        id = "5",
                        imageUrl = R.drawable.earthbound,
                        title = "Earthbound",
                        description = "Uno de los más icónicos juegos de nintendo por su historia y divertidos personajes.",
                        rating = 8.7,
                        genre = "Terror",
                        anio = 2010
                    )
                )
            ),
            Section(
                title = "Exclusivos de XBOX",
                items = listOf(
                    Program(
                        id = "1",
                        imageUrl = R.drawable.proyectox,
                        title = "Stranger Things",
                        description = "Cuando un niño desaparece, un pequeño pueblo descubre un misterio que involucra experimentos secretos, fuerzas sobrenaturales aterradoras y una niña extraña.",
                        rating = 8.7,
                        genre = "Terror",
                        anio = 2010
                    ),
                    Program(
                        id = "2",
                        imageUrl = R.drawable.click,
                        title = "Stranger Things",
                        description = "Cuando un niño desaparece, un pequeño pueblo descubre un misterio que involucra experimentos secretos, fuerzas sobrenaturales aterradoras y una niña extraña.",
                        rating = 8.7,
                        genre = "Terror",
                        anio = 2010
                    ),
                    Program(
                        id = "3",
                        imageUrl = R.drawable.detectivepikachu,
                        title = "Stranger Things",
                        description = "Cuando un niño desaparece, un pequeño pueblo descubre un misterio que involucra experimentos secretos, fuerzas sobrenaturales aterradoras y una niña extraña.",
                        rating = 8.7,
                        genre = "Terror",
                        anio = 2010
                    ),
                    Program(
                        id = "4",
                        imageUrl = R.drawable.qpa2,
                        title = "Stranger Things",
                        description = "Cuando un niño desaparece, un pequeño pueblo descubre un misterio que involucra experimentos secretos, fuerzas sobrenaturales aterradoras y una niña extraña.",
                        rating = 8.7,
                        genre = "Terror",
                        anio = 2010
                    ),
                    Program(
                        id = "5",
                        imageUrl = R.drawable.mcklovin,
                        title = "Stranger Things",
                        description = "Cuando un niño desaparece, un pequeño pueblo descubre un misterio que involucra experimentos secretos, fuerzas sobrenaturales aterradoras y una niña extraña.",
                        rating = 8.7,
                        genre = "Terror",
                        anio = 2010
                    )
                )
            ),
            Section(
                title = "FPS",
                items = listOf(
                    Program(
                        id = "1",
                        imageUrl = R.drawable.splatoon3,
                        title = "Splatoon 3",
                        description = "Domina tu territorio llenandolo de pintura con el entretenido repertorio de personajes que este juego tiene para ofrecer",
                        rating = 8.7,
                        genre = "Caricatura/FPS",
                        anio = 2022
                    ),
                    Program(
                        id = "2",
                        imageUrl = R.drawable.blackops2,
                        title = "Call of Duty BlackOps 2",
                        description = "Derrota a tus enemigos, elimina zombies y domina las armas.",
                        rating = 8.7,
                        genre = "FPS/Zombies",
                        anio = 2012
                    ),
                    Program(
                        id = "3",
                        imageUrl = R.drawable.battlefield,
                        title = "Battelfield",
                        description = "Lidera tropas aliadas y disfruta esta inmersiva experiencia.",
                        rating = 8.7,
                        genre = "FPS",
                        anio = 2022
                    ),
                    Program(
                        id = "4",
                        imageUrl = R.drawable.metro2033,
                        title = "Metro 2033",
                        description = "Explora el metro y se la salvación para la población.",
                        rating = 8.7,
                        genre = "Terror/FPS",
                        anio = 2023
                    ),
                    Program(
                        id = "5",
                        imageUrl = R.drawable.fallout4,
                        title = "Fallout 4",
                        description = "Protege al yermo de sus peligros.",
                        rating = 8.7,
                        genre = "Acción/FPS/Aventura",
                        anio = 2010
                    )
                )
            ),
            Section(
                title = "Sé el número uno en las peleas",
                items = listOf(
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
                        imageUrl = R.drawable.contagion,
                        title = "Stranger Things",
                        description = "Cuando un niño desaparece, un pequeño pueblo descubre un misterio que involucra experimentos secretos, fuerzas sobrenaturales aterradoras y una niña extraña.",
                        rating = 8.7,
                        genre = "Terror",
                        anio = 2010
                    )
                )
            )
        )

        val adapter = SectionAdapter(sections)
        sectionsRecyclerView.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_home, menu)
        return true
    }

}
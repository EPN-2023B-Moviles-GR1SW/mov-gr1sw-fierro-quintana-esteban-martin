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
import com.example.examenmov.ui.theme.ExamenMovTheme
import com.google.android.material.bottomnavigation.BottomNavigationView

class DescargasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.descargas_activity)
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
    }


}
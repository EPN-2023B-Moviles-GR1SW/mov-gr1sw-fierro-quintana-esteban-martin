package com.example.app1_gr1sw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar

class ACicloVida : AppCompatActivity() {
    var textoGlobal = ""

    fun mostrarSnackBar(texto:String){
        textoGlobal = textoGlobal + "" + texto
        Snackbar
            .make(findViewById(R.id.cl_ciclo_vida),textoGlobal,Snackbar.LENGTH_INDEFINITE)
            .show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aciclo_vida)
    }

    override fun onStart() {
        super.onStart()
        mostrarSnackBar("OnStart")
    }

    override fun onResume() {
        super.onResume()
        mostrarSnackBar("onresume")
    }

    override fun onRestart() {
        super.onRestart()
        mostrarSnackBar("onrestart")
    }

    override fun onPause() {
        super.onPause()
        mostrarSnackBar("onpause")
    }

    override fun onStop() {
        super.onStop()
        mostrarSnackBar("onstop")
    }

    override fun onDestroy() {
        super.onDestroy()
        mostrarSnackBar("ondestroy")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            putString("textoGuardado",textoGlobal)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val textoRecuperado: String? = savedInstanceState.getString("textoGuardado")
        if(textoRecuperado != null){
            mostrarSnackBar(textoRecuperado)
            textoGlobal = textoRecuperado
        }
    }
}
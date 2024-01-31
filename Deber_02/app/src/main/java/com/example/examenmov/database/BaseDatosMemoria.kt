package com.example.examenmov.database

import com.example.examen.models.Estudiante

class BaseDatosMemoria {
    companion object {
        val arregloBEntrenador = arrayListOf<Estudiante>()

        init {
            arregloBEntrenador
                .add(
                    Estudiante("Martin", "fierro")
                )

            arregloBEntrenador
                .add(
                    Estudiante("Martina", "fierro")
                )

            arregloBEntrenador
                .add(
                    Estudiante("Martins", "fierro")
                )
        }
    }
}
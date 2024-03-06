package com.example.examenmov

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ManejadorCalificaciones {
    companion object {
        private val db = FirebaseFirestore.getInstance()

        suspend fun obtenerListaCalificaciones(): MutableList<Calificacion> {
            val listaCalificaciones: MutableList<Calificacion> = mutableListOf()
                val result = db.collection("calificaciones").get().await()
                for (document in result) {
                    try {
                        val nombre = document.getString("nombre").toString()
                        val descripcion = document.getString("descripcion").toString()
                        val calificacion = document.getString("calificacion").toString()

                        // Creando y añadiendo el objeto Calificacion a la lista
                       // val calificacionObj = Calificacion(calificacion, nombre, descripcion)
                        listaCalificaciones.add(Calificacion(calificacion, nombre, descripcion))
                    } catch (e: Exception) {
                        println(e)
                        println("Error al convertir documento: ${document.id} a Calificacion")
                    }
                }
            return listaCalificaciones
        }
    }
}

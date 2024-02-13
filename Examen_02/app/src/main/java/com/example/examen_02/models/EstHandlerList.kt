package com.example.examen_02.models

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EstHandlerList {


    companion object {
        val db = Firebase.firestore
        val collectionName = "students"
        val collectionRef = db.collection(collectionName)

        val listaEstudiantes: MutableMap<String, Estudiante> = mutableMapOf()
        var listaIds: MutableList<String> = mutableListOf()

        init {
            actualizarLista()
        }
        fun actualizarLista(){
            collectionRef.get()
                .addOnSuccessListener { result ->
                    listaEstudiantes.clear()
                    listaIds.clear()
                    for (document in result) {
                        Thread.sleep(1000)
                        val documentRef = collectionRef.document(document.id)
                        println(document.id)
                        listaIds.add(document.id)
                        documentRef.get()
                            .addOnSuccessListener { documentSnapshot ->
                                println("id:" + document.id)
                                if (documentSnapshot.exists()) {
                                    val nombre = documentSnapshot.getString("nombre")
                                    val apellido = documentSnapshot.getString("apellido")
                                    listaEstudiantes[document.id] = Estudiante(nombre!!, apellido!!)

                                    listaEstudiantes[document.id]?.let { println(it.nombre) }
                                } else {
                                    println("No existe el documento")
                                }
                            }
                    }
                }
                .addOnFailureListener { exception ->
                    Log.w(TAG, "Error getting documents.", exception)
                }

        }
        fun obtenerLista(): MutableMap<String, Estudiante> {
            return listaEstudiantes
        }
        fun pruebasss(){
            println(listaEstudiantes.toString())
            println(listaIds.toString())
        }
        fun obtenerIndexLista(clave:String): Int {
            return listaIds.indexOf(clave)
        }
        fun obtenerIdLista(index:Int): String {
            return listaIds[index]
        }
        fun agregarEstudiante(nombre: String, apellido: String) {
            println("Tratando de guardar $nombre y $apellido")
            val datosAGuardar = Estudiante(
                nombre = nombre,
                apellido = apellido
                // Asigna valores para otros campos según sea necesario
            )
            collectionRef.add(datosAGuardar)
                .addOnSuccessListener { documentReference ->
                    println("Creado:" + documentReference.id)

                }
                .addOnFailureListener { exception ->
                   println("Fallo al guardar")
                }

        }


        fun editarEstudiante(
            idEstudiante: String,
            nuevoNombre: String? = null,
            nuevoApellido: String? = null,
            ) {

            val documentRef = collectionRef.document(idEstudiante)
            val datosAActualizar = hashMapOf(
                "nombre" to nuevoNombre,
                "apellido" to nuevoApellido // nuevoValor2, etc.
                // Agrega otros campos y valores según sea necesario
            )
            documentRef.update(datosAActualizar as Map<String, Any>)
                .addOnSuccessListener {
                    // La operación de actualización fue exitosa
                }
                .addOnFailureListener { exception ->
                    // Maneja errores aquí
                }

        }
        fun eliminarEstudiante(idEstudiante: String) {
            val documentRef = collectionRef.document(idEstudiante)
            documentRef.delete()
                .addOnSuccessListener {
                    // La operación de eliminación fue exitosa
                }
                .addOnFailureListener { exception ->
                    // Maneja errores aquí
                }
        }

    }

}
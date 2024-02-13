package com.example.examen_02.models

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Estudiante (
    var nombre: String,
    var apellido: String,
    var curso: Int?,
    val paralelo: String,
    val diaCumpleanos: Int?,
    val calificaciones: MutableList<Calificacion>
) {
    constructor(nombre: String, apellido: String, curso: Int?, paralelo: String, diaCumpleanos: Int?) :
            this(nombre, apellido, curso, paralelo, diaCumpleanos, mutableListOf())

    constructor(nombre: String, apellido: String) :
            this(nombre, apellido, null, "", null, mutableListOf())

    val db = Firebase.firestore
    val collectionName = "students"
    val subcollectionName = "calificacion"
    val mainCollectionRef = db.collection(collectionName)
    val listaCalIds: MutableList<String> = mutableListOf()

    fun actualizarCalificaciones(StudentID: String){
        val documentRef = mainCollectionRef.document(StudentID)
        val subCollectionRef = documentRef.collection(subcollectionName)
        subCollectionRef
            .get()
            .addOnSuccessListener { querySnapshot ->
                for (document in querySnapshot) {
                    calificaciones.clear()
                    val subDocRef =subCollectionRef.document(document.id)
                    subDocRef.get()
                        .addOnSuccessListener { documentSnapshot ->
                            println("idcal:" + document.id)
                            listaCalIds.add(document.id)
                            if (documentSnapshot.exists()) {

                                val materia = documentSnapshot.getString("materia")
                                val valor = documentSnapshot.getLong("valor") ?: 0
                                val nuevaCalificacion = Calificacion(valor.toDouble(), materia!!)
                                calificaciones.add(nuevaCalificacion)

                            } else {
                                println("No existe el documento")
                            }
                        }
                }

            }
            .addOnFailureListener { exception ->
                println("error")
            }

    }
    fun obtenerCalificaciones(): MutableList<Calificacion> {
        return calificaciones
    }
    // Método para agregar una calificación
    fun agregarCalificacion(valor: Double, materia: String, StringID:String) {
        val documentRef = mainCollectionRef.document(StringID)
        val subcollectionRef = documentRef.collection(subcollectionName)
        val nuevaCalificacion = Calificacion(
            valor= valor,
            materia= materia
        )
        subcollectionRef.add(nuevaCalificacion)
            .addOnSuccessListener { documentReference ->
                // La operación de almacenamiento fue exitosa
                // Puedes obtener el ID del nuevo documento en la subcolección usando documentReference.id si es necesario
            }
            .addOnFailureListener { exception ->
                // Maneja errores aquí
            }
        println("Calificación agregada: Materia: $materia, Nota: $valor")
    }
    fun obtenerIdLista(index:Int): String {
        println(listaCalIds[index])
        return listaCalIds[index]
    }
    // Método para editar una calificación por materia
    fun editarCalificacion(
        materia: String,
        valor: Double,
        StringID: String,
        CalID: String
    ) {
        val documentRef = mainCollectionRef.document(StringID)
        val subcollectionRef = documentRef.collection(subcollectionName)
        val subDocumentRef = subcollectionRef.document(CalID)

        val datosAActualizar = hashMapOf(
            "materia" to materia,
            "valor" to valor // nuevoValor2, etc.
            // Agrega otros campos y valores según sea necesario
        )
        subDocumentRef.update(datosAActualizar as Map<String, Any>)
            .addOnSuccessListener {
                // La operación de actualización fue exitosa
            }
            .addOnFailureListener { exception ->
                // Maneja errores aquí
            }

        println("Calificación editada: Materia: $materia, Nueva nota: $valor")
    }

    // Método para eliminar una calificación por materia
    fun eliminarCalificacion(StringID: String,CalID: String) {
        val documentRef = mainCollectionRef.document(StringID)
        val subcollectionRef = documentRef.collection(subcollectionName)
        val subDocumentRef = subcollectionRef.document(CalID)

        subDocumentRef.delete()
            .addOnSuccessListener {
                // La operación de eliminación fue exitosa
            }
            .addOnFailureListener { exception ->
                // Maneja errores aquí
            }
    }

}
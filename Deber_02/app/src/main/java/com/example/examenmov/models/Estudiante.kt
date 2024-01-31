package com.example.examen.models

class Estudiante(
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

    constructor():
            this("", "", null, "", null, mutableListOf())

    fun obtenerCalificaciones(): MutableList<Calificacion> {
        return calificaciones
    }
    fun verCalificaciones() {
        if(calificaciones.isNotEmpty()){
            calificaciones.forEach{
                println(it.valor)
            }
        }else{
            println("Estudiante sin calificaciones")
        }



    }

    // Método para agregar una calificación
    fun agregarCalificacion(valor: Double, materia: String) {
        val nuevaCalificacion = Calificacion(valor, materia)
        calificaciones.add(nuevaCalificacion)
        println("Calificación agregada: Materia: $materia, Nota: $valor")
    }

    // Método para editar una calificación por materia
    fun editarCalificacion(index: Int, materia: String, valor: Double ) {
        val calificacion = calificaciones[index]
        calificacion.valor = valor
        calificacion.materia = materia
        println("Calificación editada: Materia: $materia, Nueva nota: $valor")
    }

    // Método para eliminar una calificación por materia
    fun eliminarCalificacion(materia: String) {
        val calificacion = calificaciones.find { it.materia == materia }
        if (calificacion != null) {
            calificaciones.remove(calificacion)
            println("Calificación eliminada: Materia: $materia")
        } else {
            println("No se encontró una calificación para la materia $materia")
        }
    }

}
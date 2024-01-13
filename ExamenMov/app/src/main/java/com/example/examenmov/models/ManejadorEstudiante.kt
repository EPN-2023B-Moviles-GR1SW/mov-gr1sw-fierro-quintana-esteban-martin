package com.example.examen.models

import android.widget.Toast
import com.example.examenmov.MainActivity
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream
import java.util.Date

public class ManejadorEstudiante {
    companion object {
        val listaEstudiantes: MutableMap<Int, Estudiante> = mutableMapOf()

        init {
            //cargarDatos()
            agregarEstudiante("Martin", "Fierro")
            agregarEstudiante("Juan", "Perez")
            listaEstudiantes[1]?.agregarCalificacion(8.0,"Matematicas",1)

        }
        fun obtenerLista(): MutableMap<Int, Estudiante> {
            return listaEstudiantes
        }
        fun agregarEstudiante(
            nombre:String, apellido:String, curso: Int? =null,
            paralelo:String="Por editar", diaCum: Int? =null) {
            val estudiante = Estudiante(nombre,apellido,curso,paralelo,diaCum)
            if (!listaEstudiantes.containsValue(estudiante)) {
                val newKey = if (listaEstudiantes.isEmpty()) 1 else listaEstudiantes.keys.maxOrNull()!! + 1
                listaEstudiantes[newKey] = estudiante
                //listaEstudianteCalificaciones.add(Pair(newKey,Calificacion()))
                //guardarDatos()
                println("Se agrego el estudiante")
            } else {
                println("Estudiante ya existe!")
            }

        }

        fun obtenerIdEstudiante(nombre: String, apellido: String=""): List<Int> {
            val idsEncontrados = listaEstudiantes.entries
                .filter { it.value.nombre == nombre || it.value.apellido == apellido  }
                .map { it.key }

            return if (idsEncontrados.isNotEmpty()) {
                println("Se encontraron estudiantes con el nombre $nombre. IDs: $idsEncontrados")
                idsEncontrados
            } else {
                println("No se encontraron estudiantes con el nombre $nombre.")
                emptyList()
            }
        }




        fun editarEstudiante(idEstudiante: Int,
                             nuevoNombre: String? = null,
                             nuevoApellido: String? = null,
                             nuevoCurso: Int? = null) {
            val estudiante = listaEstudiantes[idEstudiante]

            if (estudiante != null) {
                // Actualizar solo los campos proporcionados
                nuevoNombre?.let { estudiante.nombre = it }
                nuevoApellido?.let { estudiante.apellido = it }
                nuevoCurso?.let { estudiante.curso = it }

                println("Estudiante con ID $idEstudiante editado exitosamente: $estudiante")
            } else {
                println("Estudiante no encontrado con el ID $idEstudiante")
            }
        }

        fun eliminarEstudiante(idEstudiante: Int) {
            if (listaEstudiantes.containsKey(idEstudiante)) {
                listaEstudiantes.remove(idEstudiante)
                //guardarDatos()
            } else {
                println("Error: El estudiante a eliminar no existe.")
            }
        }
        /*
            fun obtenerCalificaciones(idEstudiante: Int): List<Calificacion> {
                return listaEstudianteCalificaciones[idEstudiante] ?: emptyList()
            }
        */

        fun verListaEstudiantes() {
            println("Lista de Estudiantes con Calificaciones:")
            for ((key, estudiante) in listaEstudiantes) {
                println("Estudiante-ID:${key}: ${estudiante.nombre} ${estudiante.apellido}")
                if (estudiante.calificaciones.isNotEmpty()){
                    estudiante.verCalificaciones()
                }
                else{
                    println("Sin calificaciones")
                }

            }
        }


        private fun guardarDatos() {
            ObjectOutputStream(FileOutputStream("datos.txt")).use {
                it.writeObject(listaEstudiantes)
                it.writeObject(listaEstudiantes)
            }
        }

        private fun cargarDatos() {
            try {
                ObjectInputStream(FileInputStream("datos.txt")).use {
                    val estudiantesGuardados = it.readObject() as MutableMap<Int, Estudiante>

                    listaEstudiantes.putAll(estudiantesGuardados)

                }
            } catch (e: FileNotFoundException) {
                // Manejar la excepción si el archivo no existe (primera ejecución)
            }
        }
    }

}
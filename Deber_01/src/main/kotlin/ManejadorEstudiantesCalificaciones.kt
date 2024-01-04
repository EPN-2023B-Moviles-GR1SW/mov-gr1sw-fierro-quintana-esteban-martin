import java.io.*
import java.util.*

class ManejadorEstudiantesCalificaciones {
    val listaEstudiantes: MutableMap<Int, Estudiante> = mutableMapOf()
    val listaEstudianteCalificaciones: MutableList<Pair<Int, Calificacion>> = mutableListOf()
    //private val listaEstudianteCalificaciones: MutableMap<Int, Calificacion> = mutableMapOf()

    init {
        cargarDatos()
    }

    fun agregarEstudiante(estudiante: Estudiante) {
        if (!listaEstudiantes.containsValue(estudiante)) {
            val newKey = if (listaEstudiantes.isEmpty()) 1 else listaEstudiantes.keys.maxOrNull()!! + 1
            listaEstudiantes[newKey] = estudiante
            //listaEstudianteCalificaciones.add(Pair(newKey,Calificacion()))
            guardarDatos()
            println("Se agrego el estudiante")
        } else {
            println("Estudiante ya existe!")
        }

    }

    fun obtenerIdEstudiante(estudianteABuscar: Estudiante): Int {
        for ((key, estudiante) in listaEstudiantes) {
            if (estudiante == estudianteABuscar) {
                return key
            }
        }
        return -1
    }

    fun agregarNuevaCalificacion(idEstudiante: Int, nuevaCalificacion: Calificacion) {
        if(listaEstudiantes.containsKey(idEstudiante)){
            nuevaCalificacion.fechaUltimoCambio = Date()
            listaEstudianteCalificaciones.add(Pair(idEstudiante,nuevaCalificacion))
            guardarDatos()
            println("Se agrego la calificacion")
        }else{
            println("id no encontrado")
        }

    }
    /*
    fun editarCalificacion(idEstudiante: Int, datosACambiar: Calificacion){
        val index = listaEstudianteCalificaciones.indexOfFirst { (id, calificacion) ->
            id == idEstudiante && calificacion == datosACambiar
        }

        if(listaEstudianteCalificaciones.contains(idEstudiante)){
            listaEstudianteCalificaciones
        }
    }
    fun eliminarCalificacion(idEstudiante: Int, codigoMateria:Int){
        if(listaEstudianteCalificaciones.containsKey(idEstudiante)){
            for((key,calificaciones) in listaEstudianteCalificaciones){
                calificaciones[key] = datosACambiar
            }
        }
    }
    */


    fun editarEstudiante(idEstudiante: Int, datosACambiar: Estudiante) {
        if (listaEstudiantes.containsKey(idEstudiante)) {
            listaEstudiantes[idEstudiante] = datosACambiar
            guardarDatos()
        } else {
            println("Error: El estudiante a editar no existe.")
        }
    }

    fun eliminarEstudiante(idEstudiante: Int) {
        if (listaEstudiantes.containsKey(idEstudiante)) {
            listaEstudiantes.remove(idEstudiante)
            listaEstudianteCalificaciones.removeAll { (id, _) -> id == idEstudiante }
            //listaEstudianteCalificaciones.remove(idEstudiante)
            guardarDatos()
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
            val calificacionesEstudiante = listaEstudianteCalificaciones.filter { (id,_) -> id==key }
            if(calificacionesEstudiante.isNotEmpty()){
                println("Calificaciones:")
                calificacionesEstudiante.forEach{(_,objeto)-> println(objeto)}
            }else{
                println("No tiene calificaciones")
            }


        }
    }


//    fun verListaEstudiantes() {
//        println("Lista de Estudiantes con Calificaciones:")
//        for ((key, estudiante) in listaEstudiantes) {
//            println("Estudiante-ID:${key}: ${estudiante.nombre} ${estudiante.apellido}")
//            val calificacionesEstudiante = listaEstudianteCalificaciones[key] ?: emptyList()
//            if (calificacionesEstudiante.isNotEmpty()) {
//                println("Calificaciones:")
//                for (calificacion in calificacionesEstudiante) {
//                    println("- Materia: ${calificacion.materia}, Valor: ${calificacion.valor}, Pasa: ${calificacion.pasa}, Fecha: ${calificacion.fechaUltimoCambio}")
//                }
//            } else {
//                println("Este estudiante no tiene calificaciones.")
//            }
//            println()
//        }
//    }

    private fun guardarDatos() {
        ObjectOutputStream(FileOutputStream("datos.txt")).use {
            it.writeObject(listaEstudiantes)
            it.writeObject(listaEstudianteCalificaciones)
        }
    }

    private fun cargarDatos() {
        try {
            ObjectInputStream(FileInputStream("datos.txt")).use {
                val estudiantesGuardados = it.readObject() as MutableMap<Int, Estudiante>
                val calificacionesGuardadas = it.readObject() as MutableList<Pair<Int, Calificacion>>

                listaEstudiantes.putAll(estudiantesGuardados)
                //estudiantes.addAll(estudiantesGuardados)
                listaEstudianteCalificaciones.addAll(calificacionesGuardadas)
                //listaEstudianteCalificaciones.putAll(calificacionesGuardadas)
            }
        } catch (e: FileNotFoundException) {
            // Manejar la excepción si el archivo no existe (primera ejecución)
        }
    }
}

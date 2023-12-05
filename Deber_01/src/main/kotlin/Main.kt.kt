import java.io.*
import java.util.Date
class ManejadorEstudiantesCalificaciones {
    private val estudiantes: MutableList<Estudiante> = mutableListOf()
    private val calificaciones: MutableMap<Estudiante, MutableList<Calificacion>> = mutableMapOf()

    init {
        cargarDatos()
    }

    fun agregarEstudiante(estudiante: Estudiante) {
        estudiantes.add(estudiante)
        calificaciones[estudiante] = mutableListOf()
        guardarDatos()
    }

    fun agregarCalificacion(estudiante: Estudiante, calificacion: Calificacion) {
        calificacion.fechaUltimoCambio = Date()
        calificaciones[estudiante]?.add(calificacion)
        guardarDatos()
    }
    fun editarEstudiante(estudianteAntiguo: Estudiante, estudianteNuevo: Estudiante) {
        if (estudiantes.contains(estudianteAntiguo)) {
            estudiantes[estudiantes.indexOf(estudianteAntiguo)] = estudianteNuevo
            calificaciones[estudianteNuevo] = calificaciones.remove(estudianteAntiguo) ?: mutableListOf()
            guardarDatos()
        } else {
            println("Error: El estudiante a editar no existe.")
        }
    }

    fun eliminarEstudiante(estudiante: Estudiante) {
        if (estudiantes.contains(estudiante)) {
            estudiantes.remove(estudiante)
            calificaciones.remove(estudiante)
            guardarDatos()
        } else {
            println("Error: El estudiante a eliminar no existe.")
        }
    }
    fun obtenerCalificaciones(estudiante: Estudiante): List<Calificacion> {
        return calificaciones[estudiante] ?: emptyList()
    }


    fun verListaEstudiantes() {
        println("Lista de Estudiantes con Calificaciones:")
        for (estudiante in estudiantes) {
            println("Estudiante: ${estudiante.nombre} ${estudiante.apellido}")
            val calificacionesEstudiante = calificaciones[estudiante] ?: emptyList()
            if (calificacionesEstudiante.isNotEmpty()) {
                println("Calificaciones:")
                for (calificacion in calificacionesEstudiante) {
                    println("- Materia: ${calificacion.materia}, Valor: ${calificacion.valor}, Pasa: ${calificacion.pasa}, Fecha: ${calificacion.fechaUltimoCambio}")
                }
            } else {
                println("Este estudiante no tiene calificaciones.")
            }
            println()
        }
    }

    private fun guardarDatos() {
        ObjectOutputStream(FileOutputStream("datos.dat")).use {
            it.writeObject(estudiantes)
            it.writeObject(calificaciones)
        }
    }

    private fun cargarDatos() {
        try {
            ObjectInputStream(FileInputStream("datos.dat")).use {
                val estudiantesGuardados = it.readObject() as MutableList<Estudiante>
                val calificacionesGuardadas = it.readObject() as MutableMap<Estudiante, MutableList<Calificacion>>

                estudiantes.addAll(estudiantesGuardados)
                calificaciones.putAll(calificacionesGuardadas)
            }
        } catch (e: FileNotFoundException) {
            // Manejar la excepción si el archivo no existe (primera ejecución)
        }
    }
}

fun main() {
    val manejador = ManejadorEstudiantesCalificaciones()

    val estudiante1 = Estudiante("Martin", "Fierro", "Noveno", "A", 19)
    val calificacion1 = Calificacion(90.5, true, "Historia", "HIS101", Date())

    manejador.agregarEstudiante(estudiante1)
    manejador.agregarCalificacion(estudiante1, calificacion1)

    val calificacionesEstudiante1 = manejador.obtenerCalificaciones(estudiante1)
    println("Calificaciones de ${estudiante1.nombre} ${estudiante1.apellido}: $calificacionesEstudiante1")

    manejador.verListaEstudiantes()

    val estudianteNuevo = Estudiante("Juan", "Perez", "11B", "B", 19)
    manejador.editarEstudiante(estudiante1, estudianteNuevo)

    println("\nLista de estudiantes después de editar:")
    manejador.verListaEstudiantes()

    // Eliminar estudiante
    manejador.eliminarEstudiante(estudianteNuevo)

    println("\nLista de estudiantes después de eliminar:")
    manejador.verListaEstudiantes()

}
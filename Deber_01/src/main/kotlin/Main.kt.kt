import java.util.*
val manejador = ManejadorEstudiantesCalificaciones()
fun main() {
    var opcion: Int

    do {
        // Mostrar el menú
        println("Menú:")
        println("1. Ver Lista de Estudiantes")
        println("2. Ingresar un nuevo estudiante")
        println("3. Ingresar calificacion")
        println("4. Actualizar estudiante")
        println("5. Eliminar Estudiante")
        println("0. Salir")

        // Solicitar la entrada del usuario
        print("Seleccione una opción: ")
        opcion = readLine()?.toIntOrNull() ?: -1

        // Procesar la opción seleccionada
        when (opcion) {
            1 -> manejador.verListaEstudiantes()
            2 -> ingresarUnEstudiante(manejador)
            3 -> ingresarCalificacion(manejador)
            4 -> actualizarEstudiante()
            5 -> eliminarEstudiante()
            0 -> println("Saliendo del programa.")
            else -> println("Opción no válida. Inténtalo de nuevo.")
        }

        // Separador
        println("".padEnd(30, '-'))

    } while (opcion != 0)


}
fun gg(){
    //val manejador = ManejadorEstudiantesCalificaciones()

    val estudiante1 = Estudiante("Martin", "Fierro", 9, "A", 19)
    val calificacion1 = Calificacion(8.0, "Historia", 1)
    val calificacion2 = Calificacion(9.0, "Historia", 1)

    manejador.agregarEstudiante(estudiante1)

    manejador.agregarNuevaCalificacion(manejador.obtenerIdEstudiante(estudiante1), calificacion1)

    //val calificacionesEstudiante1 = manejador.obtenerCalificaciones(manejador.obtenerIdEstudiante(estudiante1))
    //println("Calificaciones de ${estudiante1.nombre} ${estudiante1.apellido}: $calificacionesEstudiante1")

    manejador.verListaEstudiantes()

    manejador.editarCalificacion(1)

    val datosActualizados = Estudiante("Juan", "Perez", 9, "B", 19)
    manejador.editarEstudiante(manejador.obtenerIdEstudiante(estudiante1), datosActualizados)

    println("\nLista de estudiantes después de editar:")
    manejador.verListaEstudiantes()

    // Eliminar estudiante
    manejador.eliminarEstudiante(manejador.obtenerIdEstudiante(estudiante1))

    println("\nLista de estudiantes después de eliminar:")
    manejador.verListaEstudiantes()
}
fun ingresarUnEstudiante(manejador: ManejadorEstudiantesCalificaciones){
    println("Por favor ingrese los siguientes datos:")
    print("Ingrese nombre: ")
    val nombre = readLine().toString()
    print("Ingrese apellido: ")
    val apellido = readLine().toString()
    print("Ingrese curso en numero: ")
    val curso: Int? = readLine()?.toInt()
    print("Ingrese paralelo: ")
    val paralelo = readLine().toString()
    print("Ingrese dia cumpleaños: ")
    val cumple = readLine()?.toInt()

    manejador.agregarEstudiante(Estudiante(nombre,apellido,curso,paralelo,cumple))

}
fun ingresarCalificacion(manejador: ManejadorEstudiantesCalificaciones) {
    println("Por favor ingrese los siguientes datos:")
    print("Ingrese el id del estudiante: ")
    val id = readLine()?.toInt()
    print("Ingrese valor de la calificacion 0-10: ")
    val valor = readLine()?.toDouble()
    print("Ingrese la materia: ")
    val materia = readLine().toString()
    print("Ingrese el codigo de la materia ")
    val paralelo = readLine()?.toInt()

    if (id != null) {
        manejador.agregarNuevaCalificacion(id, Calificacion(valor,materia,paralelo))

    }
}
fun actualizarEstudiante(){
    println("Por favor ingrese los siguientes datos:")
    print("Ingrese el id del estudiante a editar: ")
    val id = readLine()?.toInt()
    print("Ingrese nombre: ")
    val nombre = readLine().toString()
    print("Ingrese apellido: ")
    val apellido = readLine().toString()
    print("Ingrese curso en numero: ")
    val curso: Int? = readLine()?.toInt()
    print("Ingrese paralelo: ")
    val paralelo = readLine().toString()
    print("Ingrese dia cumpleaños: ")
    val cumple = readLine()?.toInt()

    if (id != null) {
        manejador.editarEstudiante(id,Estudiante(nombre,apellido,curso,paralelo,cumple))
    }

}

fun eliminarEstudiante(){
    println("Por favor ingrese los siguientes datos:")
    print("Ingrese el id del estudiante a editar: ")
    val id = readLine()?.toInt()
    if (id != null) {
        manejador.eliminarEstudiante(id)
    }
}
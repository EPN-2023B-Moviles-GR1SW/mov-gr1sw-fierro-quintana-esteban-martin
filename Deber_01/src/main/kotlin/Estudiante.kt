import java.io.Serializable
data class Estudiante(
    val nombre: String,
    val apellido: String,
    val curso: Int?,
    val paralelo: String,
    val diaCumpleanos: Int?
) : Serializable
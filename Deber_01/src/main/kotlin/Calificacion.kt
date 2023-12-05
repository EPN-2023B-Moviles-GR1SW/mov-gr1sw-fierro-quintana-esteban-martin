import java.io.Serializable
import java.util.Date

data class Calificacion(
    val valor: Double,
    val pasa: Boolean,
    val materia: String,
    val codigoMateria: String,
    var fechaUltimoCambio: Date
) : Serializable
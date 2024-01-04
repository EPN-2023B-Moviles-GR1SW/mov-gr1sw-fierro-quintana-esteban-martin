import java.io.Serializable
import java.util.Date

data class Calificacion(
    val valor: Double?,
    val pasa: Boolean,
    val materia: String,
    val codigoMateria: Int?,
    var fechaUltimoCambio: Date
) : Serializable{
    constructor(valor: Double?, materia: String, codigoMateria: Int?) : this(
        valor,
        valor!! >= 6,  // Determinar si pasa basado en la calificación
        materia,
        codigoMateria,
        Date()
    )
    constructor() : this(0.0,"desconocido",0,)
}
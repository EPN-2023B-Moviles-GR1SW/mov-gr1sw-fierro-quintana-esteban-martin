package com.example.examen.models

import java.util.Date

class Calificacion(
    var valor: Double?,
    val pasa: Boolean,
    val materia: String,
    val codigoMateria: Int?,
    var fechaUltimoCambio: Date
) {
    constructor(valor: Double?, materia: String, codigoMateria: Int?) : this(
        valor,
        valor!! >= 6,  // Determinar si pasa basado en la calificación
        materia,
        codigoMateria,
        Date()
    )
    constructor() : this(0.0,"desconocido",0,)
}
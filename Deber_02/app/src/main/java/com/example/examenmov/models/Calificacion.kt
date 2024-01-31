package com.example.examen.models

import java.util.Date

class Calificacion(
    var valor: Double?,
    val pasa: Boolean,
    var materia: String,
    val codigoMateria: Int?,
    var fechaUltimoCambio: Date
) {
    companion object {
        private var contadorCodigoMateria: Int = 0

        fun generarCodigoMateria(): Int {
            return contadorCodigoMateria++
        }
    }


    constructor(valor: Double?, materia: String) : this(
        valor,
        valor!! >= 6,  // Determinar si pasa basado en la calificación
        materia,
        generarCodigoMateria(),
        Date()
    )
    constructor() : this(0.0,"desconocido",)
}
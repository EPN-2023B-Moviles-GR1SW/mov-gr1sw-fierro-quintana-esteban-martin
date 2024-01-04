package com.example.app1_gr1sw

class BEntrenador (
    var id:Int,
    var nombre : String?,
    var descripcion: String?
){
    override fun toString(): String {
        return "${nombre} - ${descripcion}"
    }
}
package com.example.examenmov.database
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.examen.models.Estudiante

class ESqliteHelper(
    contexto: Context?, // THIS
) : SQLiteOpenHelper(
    contexto,
    "moviles", // nombre BDD
    null,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTablaEntrenador =
            """
               CREATE TABLE ESTUDIANTE(
               id INTEGER PRIMARY KEY AUTOINCREMENT,
               nombre VARCHAR(50),
               apellido VARCHAR(50)
               ) 
            """.trimIndent()
        db?.execSQL(scriptSQLCrearTablaEntrenador)
    }

    override fun onUpgrade(db: SQLiteDatabase?,
                           oldVersion: Int,
                           newVersion: Int) {}

    fun crearEntrenador(
        nombre: String,
        descripcion: String
    ): Boolean {
        val basedatosEscritura = writableDatabase
        val valoresAGuardar = ContentValues()
        valoresAGuardar.put("nombre", nombre)
        valoresAGuardar.put("descripcion", descripcion)
        val resultadoGuardar = basedatosEscritura
            .insert(
                "ESTUDIANTE", // Nombre tabla
                null,
                valoresAGuardar // valores
            )
        basedatosEscritura.close()
        return if (resultadoGuardar.toInt() == -1) false else true
    }

    fun eliminarEntrenadorFormulario(id:Int):Boolean{
        val conexionEscritura = writableDatabase
        // where ID = ?
        val parametrosConsultaDelete = arrayOf( id.toString() )
        val resultadoEliminacion = conexionEscritura
            // Delete from id = 1  ===> [ 1 ]
            .delete(
                "ESTUDIANTE", // Nombre tabla
                "nombre=?", // Consulta Where
                parametrosConsultaDelete
            )
        conexionEscritura.close()
        return if(resultadoEliminacion == -1) false else true
    }


    fun actualizarEntrenadorFormulario(
        nombre: String,
        apellido: String,
        id:Int,
    ):Boolean{
        val conexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre", nombre)
        valoresAActualizar.put("apellido", apellido)
        // where ID = ?
        val parametrosConsultaActualizar = arrayOf( id.toString() )
        val resultadoActualizacion = conexionEscritura
            .update(
                "ESTUDIANTE", // Nombre tabla
                valoresAActualizar, // Valores
                "id=?", // Consulta Where
                parametrosConsultaActualizar
            )
        conexionEscritura.close()
        return if(resultadoActualizacion == -1) false else true
    }


    fun consultarEntrenadorPorID(id: Int): Estudiante{
        val baseDatosLectura = readableDatabase
        val scriptConsultaLectura = """
            SELECT * FROM ESTUDIANTE WHERE ID = ?
        """.trimIndent()
        val parametrosConsultaLectura = arrayOf(id.toString())
        val resultadoConsultaLectura = baseDatosLectura.rawQuery(
            scriptConsultaLectura, // Consulta
            parametrosConsultaLectura, // Parametros
        )

        // logica busqueda
        val existeUsuario = resultadoConsultaLectura.moveToFirst()
        val usuarioEncontrado = Estudiante()
        val arreglo = arrayListOf<Estudiante>()
        if(existeUsuario){
            do{
                val id= resultadoConsultaLectura.getInt(0) // Indice 0
                val nombre = resultadoConsultaLectura.getString(1)
                val apellido= resultadoConsultaLectura.getString(2)
                if(id != null){
                    // llenar el arreglo con un nuevo BEntrenador
                    usuarioEncontrado.nombre = nombre
                    usuarioEncontrado.apellido = apellido
                }
            } while (resultadoConsultaLectura.moveToNext())
        }
        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return usuarioEncontrado
    }

}

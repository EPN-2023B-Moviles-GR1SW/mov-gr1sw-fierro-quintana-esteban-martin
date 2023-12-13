package com.example.app1_gr1sw

class BBaseDatosMemoria {

    companion object {
        val arregloBEntrenador = arrayListOf<BEntrenador>()

        init {
            arregloBEntrenador
                .add(
                    BEntrenador(1,"Adrian","asd@gmail.com")
                )

            arregloBEntrenador
                .add(
                    BEntrenador(2,"Martin","martin@gmail.com")
                )

            arregloBEntrenador
                .add(
                    BEntrenador(3,"Paco","paco@gmail.com")
                )
        }
    }
}
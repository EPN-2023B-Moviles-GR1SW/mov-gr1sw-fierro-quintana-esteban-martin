import java.util.Date

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val inmutable : String = "Adrian";
    var mutable = "Juan"

    val fechaNAcimiento: Date = Date()

    val estadoCivil = "S"

    when(estadoCivil){
        ("C") -> {
            println("casado")
        }
        "S" -> {
            println("s")
        }
        else -> {
            println("n/i")
        }
    }

    println(calcularSueldo(10.00))

    val sumaUno = Suma(1,1)
    println(sumaUno)
    val sumaDos = Suma(null,1)
    val sumaTres = Suma(1,null)

    sumaUno.sumar()
    sumaDos.sumar()

    println(Suma(1,null))
    println(Suma.historialSumas)


    //arreglo estatico
    val arregloEstatico: Array<Int> = arrayOf(1,2,3)

    //arreglo dinamico
    val arregloDinamico: ArrayList<Int> = arrayListOf(1,2,3,4,5,6)

    //for each no devuelve nada
    val respuestaForEach :Unit = arregloDinamico.forEach({
        valorActual: Int -> print(valorActual)
    })
    println()
    //version facil no se puee en el estatico
    arregloDinamico.forEach{ print(it) }
    println()
    arregloEstatico.forEachIndexed{
        index: Int, i:Int ->
            println("valor: ${index} valor: ${i}")
    }

    val respuestaFilter: List<Int> = arregloDinamico.filter { it <= 5 }

    print(respuestaFilter)

    val respuestaAny: Boolean = arregloDinamico.any{
        valorActual:Int ->
        return@any (valorActual>5)
    }

    println(respuestaAny)
    val respuestaAll: Boolean = arregloDinamico.all{
            valorActual:Int ->
        return@all (valorActual>5)
    }
    println(respuestaAll)

    //acumulador reduce
z
    val respuestaReduce: Int = arregloDinamico.reduce{
        acumulado:Int, valorActual:Int ->
        return@reduce(acumulado + valorActual)
    }
    println(respuestaReduce)



}
//Unir -> void
fun imprimirNombre(nombre:String): Unit{
    println("Nombre: ${nombre}")
}
fun calcularSueldo(
    sueldo:Double,
    tasa:Double = 12.00,
    bonoEspecial: Double? = null,
):Double{
    if(bonoEspecial == null){
        return  sueldo * (100/tasa)
    }else{
        bonoEspecial.dec()
        return sueldo * (100/tasa) + bonoEspecial
    }
}


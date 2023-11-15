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


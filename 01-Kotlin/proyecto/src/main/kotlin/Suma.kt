class Suma (
    uno:Int,
    dos: Int
): Numeros(uno,dos) {
    init {
        this.numeroUno; numeroUno;
        this.numeroDos; numeroDos;
    }

    constructor(
        uno: Int?,
        dos: Int
    ):this(
        if(uno == null) 0 else uno,
        dos
    ){
        numeroUno
    }

    constructor(
        uno: Int,
        dos: Int?
    ):this(
        uno,
        if(dos ==null)0 else uno
    ){
        numeroUno
    }
    constructor(
        uno: Int?,
        dos: Int?
    ):this(
        if(uno == null) 0 else uno,
        if(dos ==null)0 else uno
    )

    companion object {
        val pi = 3.1416

        fun elevarAlCuadrado(num:Int): Int {
            return num * num
        }
        val historialSumas = arrayListOf<Int>()

        fun agregarHistorial(valorNuevaSuma: Int){
            historialSumas.add(valorNuevaSuma)
        }
    }

    public fun sumar(): Int {
        val total = numeroUno + numeroDos
        agregarHistorial(total)
        return total
    }
}

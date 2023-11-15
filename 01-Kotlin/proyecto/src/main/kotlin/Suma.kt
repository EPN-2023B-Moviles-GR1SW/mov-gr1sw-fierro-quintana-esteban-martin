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
}

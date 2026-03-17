package com.example.androidmaster

fun main() {

    //listasInmutables()
    //listasMutalbles()
    //mapas()
    //quitarDuplicados()
    //comenzarConLetraB()
    //cicloBreak()
    //unirCiudadesMayusculas()
    valorConIva()
}

fun valorConIva() {
    val precios = listOf(1000, 2000, 3000)
    val preciosIva = precios.map { precio -> precio * 1.19 }
    println(precios)
    println(preciosIva)
}

fun unirCiudadesMayusculas() {
    val ciudades = listOf("Bucaramanga", "Bogota", "Cartagena", "Barranquilla", "bogota")
    println(ciudades)

    val resultado = ciudades
        .map { it.uppercase() }
        .filter { it.startsWith("B") }
        .toSet()
        .sorted()

    println(resultado)
}

fun cicloBreak() {
    val clientes = listOf("rodney", "samuel", "cecilia", "juan")
    for (cliente in clientes) {
        if (cliente == "cecilia") break
        println(cliente)
    }
}

fun comenzarConLetraB() {
    val ciudades = listOf("Barranquilla", "Bogota", "Cartagena", "Bucaramanga")
    println(ciudades)
    val ciudadesB = ciudades.filter { it.startsWith("B") }
    println(ciudadesB)
}

fun quitarDuplicados() {
    val ciudades = listOf("Barranquilla", "Bogota", "Cartagena", "Bogota")
    println(ciudades)
    val ciudadesUnicas = ciudades.toSet()
    println(ciudadesUnicas)
}

fun mapas() {
    val clientes = mapOf(
        1 to "empresa A",
        2 to "empresa B",
        3 to "empresa C"
    )
    println(clientes[1])
}

fun listasMutalbles() {
    val equipos = mutableListOf("aire LG", "Aire Samsung")
    equipos.add("aire olimpo")
    println(equipos)


    val tecnicos = listOf("rodney", "samuel", "rodney")

    //convertimos en Set para eliminar los duplicados
    val setTecnicos = tecnicos.toSet()
    println(tecnicos)
    println(setTecnicos)
}

fun listasInmutables() {
    val tecnicos = listOf("rodney", "samuel", "cecilia", "sara")

    println("==== ciclo for ===")
    for (tecnico in tecnicos) {
        println(tecnico)
    }

    println("==== ciclo for each ====")
    tecnicos.forEach { e -> println(e) }

    println("==== mostrar solo los tecnicos que comienzan con s ====")
    val resultado = tecnicos.filter { it.startsWith('s') }
    println(resultado)

}
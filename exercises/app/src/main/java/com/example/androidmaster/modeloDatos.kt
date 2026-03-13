package com.example.androidmaster

data class Cliente2(
    val name: String = "",
    val lastName: String = ""
)

fun main() {
    val cliente = Cliente2(
        name = "rodney",
        lastName = "zapata"
    )
    println(cliente);
}
package com.example.androidmaster

class Cliente(
    var name: String,
    var lastName: String
)

fun main() {
    val cliente = Cliente(
        name = "rondey",
        lastName = "zapata"
    )
    println(cliente.name);

}
package com.example.androidmaster

fun main(){
    days()
    notas()
}

fun notas() {
    val nota=80
    val resultado=when(nota){
        in 90..100 -> "excelente"
        in 80..89 -> "bueno"
        in 70..79 -> "aceptable"
        in 60 ..69-> "regular"
        else -> "reprobado"
    }
    println(resultado);
}

fun days(){
    val day=10
    when (day){
        1 -> println("lunes")
        2 -> println("martes")
        3 -> println("miercoles")
        4 -> println("jueves")
        5 -> println("viernes")
        6, 7 -> println("fin de semana")
        else -> println("dia errado")
    }
}


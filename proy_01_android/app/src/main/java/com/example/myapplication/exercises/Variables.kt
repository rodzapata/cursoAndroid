package com.example.myapplication.exercises

fun main(){
    var name:String="Rodney"
    var age:Int =49
    var cost:Long=2500
    var total:Float=1500000.23f
    var salary:Double=5000.25
    var gender:Char='m'

    println("Bienvenido a Kotlin  ${name}, edad= ${age} , costo unitario ${cost} , total ${total} y un salario de ${salary} genero ${gender}")
    sum(5,2)
    var resultado:Int= suma2(8,25)
    println("el resultado es :  ${resultado}")
    condicional(-15)
}

fun sum(num1:Int, num2:Int){
    var total:Int =num1+num2
    println("el total es : $total")
}
fun suma2(num1: Int, num2: Int):Int{
    return num1+num2
}

fun condicional(num1: Int){
    if (num1>0)
    {
        println("positivo")
    }
    else{
        println("negativo")
    }
}
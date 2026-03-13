package com.example.androidmaster

fun createOrden(cliente:String, equipo:String):String{
    return "cliente: $cliente y  equipo= $equipo";
}


fun main(){
    val pi:Double =13.1416 ;
    //muestra error pi=3.14  ;

    var name:String ="rodney";
    name="cecilia";
    var age:Int = 51 ;
    var salary:Long = 2540000
    var interes:Float = 25.23f ;
    var numero:Double = 30.5647978
    var isActive:Boolean = true ;
    var telefono:String? =null;

    //operador Elvis
    val numeroSeguro = telefono ?: "sin numero";
    println("usuario es $name edad $age interes $interes salary $salary  numero $numero activo $isActive numero seguro $numeroSeguro" );

    val resultado:String = createOrden("rodney","Computador PC") ;
    println(resultado);

}
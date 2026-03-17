package com.example.androidmaster

class UsuarioService {
    fun crearUsuario(usuario: Usuario) {
        println("creando usuario ${usuario.name}")
    }
}

fun main(){
    val usuario= Usuario(1,"rodney","zapata")

    val service =UsuarioService()

    service.crearUsuario(usuario)
}
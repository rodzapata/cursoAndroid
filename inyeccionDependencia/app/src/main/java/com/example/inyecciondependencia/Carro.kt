package com.example.inyecciondependencia

class Carro(private val motor: Motor) {
    fun arrancar(): String {
        return motor.encender()
    }
}

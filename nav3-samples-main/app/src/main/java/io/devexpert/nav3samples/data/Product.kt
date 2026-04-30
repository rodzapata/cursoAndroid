package io.devexpert.nav3samples.data

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val description: String,
    val imageUrl: String = ""
)

val products = listOf(
    Product(1, "Smartphone X", 799.99, "Último modelo con cámara mejorada"),
    Product(2, "Laptop Pro", 1299.99, "Alto rendimiento para profesionales"),
    Product(3, "Auriculares Inalámbricos", 199.99, "Cancelación de ruido activa"),
    Product(4, "Smartwatch 4", 299.99, "Seguimiento de salud avanzado"),
    Product(5, "Tablet S7", 499.99, "Pantalla AMOLED de 120Hz")
)
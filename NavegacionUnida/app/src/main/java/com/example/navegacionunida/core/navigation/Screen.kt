package com.example.navegacionunida.core.navigation

sealed class Screen {
    data object Home : Screen()
    data object Orders : Screen()
    data class OrderDetail(val id: String) : Screen()
    data object CreateOrder : Screen()
}
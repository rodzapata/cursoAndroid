package com.example.myapplication.core.navigation

sealed interface Screen {
    data object Home : Screen
    data object Orders : Screen
    data object Settings : Screen

    data class OrderDetail(val id: Int) : Screen
    data object CreateOrder : Screen
}

enum class Tab {
    HOME, ORDERS, SETTINGS
}
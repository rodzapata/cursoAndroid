package com.example.navegacionunida.core.navigation

data class NavState(
    val backStack: List<Screen> = listOf(Screen.Home)
)
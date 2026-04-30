package com.example.myapplication.core.navigation

data class NavState(
    val currentTab: Tab = Tab.HOME,

    val stacks: Map<Tab, List<Screen>> = mapOf(
        Tab.HOME to listOf(Screen.Home),
        Tab.ORDERS to listOf(Screen.Orders),
        Tab.SETTINGS to listOf(Screen.Settings)
    )
)
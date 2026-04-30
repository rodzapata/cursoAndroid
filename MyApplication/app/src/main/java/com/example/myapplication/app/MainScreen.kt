package com.example.myapplication.app


import androidx.compose.foundation.layout.padding

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation3.ui.NavDisplay
import com.example.myapplication.core.navigation.Screen
import com.example.myapplication.core.navigation.Tab
import com.example.myapplication.feature.home.HomeScreen
import com.example.myapplication.feature.orders.CreateOrderScreen
import com.example.myapplication.feature.orders.OrderDetailScreen
import com.example.myapplication.feature.orders.OrdersScreen
import com.example.myapplication.feature.settings.SettingsScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val state by viewModel.state.collectAsState()

    val currentStack = state.stacks[state.currentTab]!!
    val currentScreen = currentStack.last()

    Scaffold(

        // 🔝 TOP BAR DINÁMICO
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (currentScreen) {
                            Screen.Home -> "Inicio"
                            Screen.Orders -> "Órdenes"
                            Screen.Settings -> "Configuración"
                            is Screen.OrderDetail -> "Detalle Orden"
                            Screen.CreateOrder -> "Nueva Orden"
                        }
                    )
                }
            )
        },

        // 🔻 BOTTOM NAV REAL
        bottomBar = {
            NavigationBar {

                NavigationBarItem(
                    selected = state.currentTab == Tab.HOME,
                    onClick = { viewModel.switchTab(Tab.HOME) },
                    icon = { Icon(Icons.Default.Home, null) },
                    label = { Text("Inicio") }
                )

                NavigationBarItem(
                    selected = state.currentTab == Tab.ORDERS,
                    onClick = { viewModel.switchTab(Tab.ORDERS) },
                    icon = { Icon(Icons.Default.List, null) },
                    label = { Text("Órdenes") }
                )

                NavigationBarItem(
                    selected = state.currentTab == Tab.SETTINGS,
                    onClick = { viewModel.switchTab(Tab.SETTINGS) },
                    icon = { Icon(Icons.Default.Settings, null) },
                    label = { Text("Config") }
                )
            }
        }

    ) { padding ->

        NavDisplay(
            backStack = currentStack,
            modifier = Modifier.padding(padding),
            onBack = { viewModel.goBack() }
        ) { screen ->

            when (screen) {

                Screen.Home -> HomeScreen()

                Screen.Orders -> OrdersScreen(
                    onOrderClick = {
                        viewModel.navigate(Screen.OrderDetail(it))
                    },
                    onCreate = {
                        viewModel.navigate(Screen.CreateOrder)
                    }
                )

                is Screen.OrderDetail -> OrderDetailScreen(screen.id)

                Screen.CreateOrder -> CreateOrderScreen()

                Screen.Settings -> SettingsScreen()
            }
        }
    }
}
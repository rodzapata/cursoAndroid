package com.example.navegacionunida.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.ui.NavDisplay
import com.example.navegacionunida.feature.home.presentation.HomeScreen
import com.example.navegacionunida.feature.orders.presentation.CreateOrderScreen
import com.example.navegacionunida.feature.orders.presentation.OrderDetailScreen
import com.example.navegacionunida.feature.orders.presentation.OrdersScreen
import com.example.navegacionunida.core.navigation.Screen


@Composable
fun AppNavigation(viewModel: MainViewModel) {

    //val state by viewModel.state.collectAsState()
    val state by viewModel.state.collectAsStateWithLifecycle()

    NavDisplay(
        backStack = state.backStack,
        onBack = { viewModel.goBack() }
    ) { screen ->

        when (screen) {

            Screen.Home -> HomeScreen(
                onGoOrders = {
                    viewModel.navigate(Screen.Orders)
                }
            )

            Screen.Orders -> OrdersScreen(
                onDetail = { id ->
                    viewModel.navigate(Screen.OrderDetail(id))
                },
                onCreate = {
                    viewModel.navigate(Screen.CreateOrder)
                }
            )

            is Screen.OrderDetail -> OrderDetailScreen(
                id = screen.id,
                onBack = { viewModel.goBack() }
            )

            Screen.CreateOrder -> CreateOrderScreen(
                onSave = {
                    viewModel.goBack()
                }
            )
        }
    }
}
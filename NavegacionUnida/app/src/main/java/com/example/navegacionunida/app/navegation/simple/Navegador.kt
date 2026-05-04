package com.example.navegacionunida.app.navegation.simple

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.navegacionunida.pantallas.SegundaPantalla
import com.example.navegacionunida.pantallas.inicio
import kotlinx.serialization.Serializable


@Serializable
data object Inicio: NavKey

//data class SegundaPantalla(val id: String)
@Serializable
data class SegundaPantalla(val id: String): NavKey

@Composable
fun navFuncionProveedor() {

    val backStack= rememberNavBackStack(Inicio)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is Inicio -> NavEntry(key) {
                    inicio { valor ->
                        backStack.add(SegundaPantalla(valor))
                    }
                }

                is SegundaPantalla -> NavEntry(key) {
                    SegundaPantalla(key.id) {
                        //backStack.add(Inicio)
                        backStack.removeLastOrNull()
                    }
                }

                else -> NavEntry(key) {
                    Text("Unknown route")
                }
            }
        }
    )
}
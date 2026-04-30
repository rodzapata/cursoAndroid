package com.aristidevs.nav3example.medium_navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.aristidevs.nav3example.screen.DetailScreen
import com.aristidevs.nav3example.screen.HomeScreen
import kotlinx.serialization.Serializable


@Serializable
data object Home2: NavKey

@Serializable
data class Detail2(val id:String): NavKey

@Serializable
data object Error: NavKey

@Composable
fun MediumNavigationWrapper(){
    val backStack = rememberNavBackStack(Home2)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when(key){
                is Home2 -> NavEntry(key){
                    HomeScreen { id ->
                        backStack.add(Detail2(id))
                    }
                }
                is Detail2 -> NavEntry(key){
                    DetailScreen(key.id){
                        backStack.removeLastOrNull()
                    }
                }
                else -> NavEntry(key = Error){
                    Text("Error :(")
                }
            }
        }
    )
}
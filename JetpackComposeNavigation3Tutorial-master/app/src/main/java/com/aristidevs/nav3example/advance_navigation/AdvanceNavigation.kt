package com.aristidevs.nav3example.advance_navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.aristidevs.nav3example.advance_navigation.Routes.Detail3
import com.aristidevs.nav3example.advance_navigation.Routes.Error
import com.aristidevs.nav3example.advance_navigation.Routes.Home3
import com.aristidevs.nav3example.core.ex.back
import com.aristidevs.nav3example.core.ex.navigateTo
import com.aristidevs.nav3example.screen.DetailScreen
import com.aristidevs.nav3example.screen.HomeScreen


@Composable
fun AdvanceNavigationWrapper() {
    val backStack = rememberNavBackStack(Home3)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.back() },
        entryProvider = entryProvider {
            entry<Home3> {
                HomeScreen { id ->
//                    backStack.add(Detail3(id))
                    backStack.navigateTo(Detail3(id))
                }
            }
            entry<Detail3> { key ->
                DetailScreen(key.id) {
                    backStack.back()
                }
            }

            entry<Error> {
                Text("Error :(")
            }
        }
    )
}
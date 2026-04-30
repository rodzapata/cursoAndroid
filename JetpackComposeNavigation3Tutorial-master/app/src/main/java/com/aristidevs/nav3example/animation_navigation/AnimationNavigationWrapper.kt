package com.aristidevs.nav3example.animation_navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.aristidevs.nav3example.advance_navigation.Routes.Detail3
import com.aristidevs.nav3example.advance_navigation.Routes.Error
import com.aristidevs.nav3example.advance_navigation.Routes.Home3
import com.aristidevs.nav3example.screen.DetailScreen
import com.aristidevs.nav3example.screen.HomeScreen


@Composable
fun AnimationNavigationWrapper() {
    val backStack = rememberNavBackStack(Home3)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Home3> {
                HomeScreen { id ->
                    backStack.add(Detail3(id))
                }
            }
            entry<Detail3> { key ->
                DetailScreen(key.id) {
                    backStack.removeLastOrNull()
                }
            }

            entry<Error> {
                Text("Error :(")
            }
        },
        transitionSpec = {
            slideInHorizontally(
                initialOffsetX = { it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { -it },
                animationSpec = tween(250)
            )
        },
        popTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(250)
            )
        },
        predictivePopTransitionSpec = {
            slideInHorizontally(
                initialOffsetX = { -it },
                animationSpec = tween(250)
            ) togetherWith slideOutHorizontally(
                targetOffsetX = { it },
                animationSpec = tween(250)
            )
        }
    )
}
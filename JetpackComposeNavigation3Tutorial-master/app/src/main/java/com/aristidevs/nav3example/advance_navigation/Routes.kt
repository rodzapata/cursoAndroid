package com.aristidevs.nav3example.advance_navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed class Routes:NavKey {
    @Serializable
    data object Home3: Routes()

    @Serializable
    data class Detail3(val id:String): Routes()

    @Serializable
    data object Error: Routes()

}
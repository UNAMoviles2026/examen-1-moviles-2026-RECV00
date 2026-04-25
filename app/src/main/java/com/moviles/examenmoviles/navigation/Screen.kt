package com.moviles.examenmoviles.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector? = null) {
    object Home : Screen("home", "Home", Icons.Default.Home)
    object Detail : Screen("detail/{spaceId}", "Detail") {
        fun createRoute(spaceId: Int) = "detail/$spaceId"
    }
    object Reservation : Screen("reservation/{spaceId}", "Reservation") {
        fun createRoute(spaceId: Int) = "reservation/$spaceId"
    }
    object Confirmation : Screen("confirmation", "Confirmation")
    object Profile : Screen("profile", "Profile", Icons.Default.Person)
}

val bottomNavItems = listOf(
    Screen.Home,
    Screen.Profile
)

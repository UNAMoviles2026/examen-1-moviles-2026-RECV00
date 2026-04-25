package com.moviles.examenmoviles.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.moviles.examenmoviles.navigation.Screen
import com.moviles.examenmoviles.navigation.bottomNavItems
import com.moviles.examenmoviles.ui.components.TopBar
import com.moviles.examenmoviles.ui.screens.*

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    // Determine if we should show back button and what the title should be
    val currentRoute = navBackStackEntry?.destination?.route
    val title = when {
        currentRoute == Screen.Home.route -> "Coworking Spaces"
        currentRoute?.startsWith("detail") == true -> "Space Details"
        currentRoute?.startsWith("reservation") == true -> "Book Space"
        currentRoute == Screen.Confirmation.route -> "Confirmed"
        currentRoute == Screen.Profile.route -> "My Profile"
        else -> "Coworking App"
    }

    val canNavigateBack = currentDestination?.route != Screen.Home.route && 
                         currentDestination?.route != Screen.Profile.route

    Scaffold(
        topBar = {
            TopBar(
                title = title,
                canNavigateBack = canNavigateBack,
                onBackClick = { navController.navigateUp() }
            )
        },
        bottomBar = {
            NavigationBar {
                bottomNavItems.forEach { screen ->
                    NavigationBarItem(
                        icon = { screen.icon?.let { Icon(it, contentDescription = null) } },
                        label = { Text(screen.title) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(
                    onSpaceClick = { spaceId ->
                        navController.navigate(Screen.Detail.createRoute(spaceId))
                    }
                )
            }
            composable(
                route = Screen.Detail.route,
                arguments = listOf(navArgument("spaceId") { type = NavType.IntType })
            ) { backStackEntry ->
                val spaceId = backStackEntry.arguments?.getInt("spaceId") ?: return@composable
                DetailScreen(
                    spaceId = spaceId,
                    onReserveClick = { id ->
                        navController.navigate(Screen.Reservation.createRoute(id))
                    }
                )
            }
            composable(
                route = Screen.Reservation.route,
                arguments = listOf(navArgument("spaceId") { type = NavType.IntType })
            ) { backStackEntry ->
                val spaceId = backStackEntry.arguments?.getInt("spaceId") ?: return@composable
                ReservationScreen(
                    spaceId = spaceId,
                    onConfirmClick = {
                        navController.navigate(Screen.Confirmation.route)
                    }
                )
            }
            composable(Screen.Confirmation.route) {
                ConfirmationScreen(
                    onBackToHome = {
                        navController.navigate(Screen.Home.route) {
                            popUpTo(Screen.Home.route) { inclusive = true }
                        }
                    }
                )
            }
            composable(Screen.Profile.route) {
                // Placeholder for Profile Screen
                Surface {
                    Text(
                        text = "User Profile Screen",
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }
            }
        }
    }
}

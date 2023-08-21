package com.example.latihan1

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

// ScreenDefinitions.kt
sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Home : Screen("home")
    object Detail : Screen("detail")
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(Screen.Login.route) {
            LoginPage(navController = navController) // Pass the NavController
        }
        composable(Screen.Home.route){
            HomeScreen(navController = navController)
        }
        composable(Screen.Detail.route){
            DetailScreen()
        }
    }
}

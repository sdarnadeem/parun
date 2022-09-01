package dev.nasyxnadeem.parun.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.nasyxnadeem.parun.screens.login.LoginScreen
import dev.nasyxnadeem.parun.screens.splash.SplashScreen

@Composable
fun ParunNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ParunScreens.SplashScreen.name) {


        // Splash Screen
        composable(route = ParunScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        // Login Screen
        composable(route = ParunScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }
    }
}
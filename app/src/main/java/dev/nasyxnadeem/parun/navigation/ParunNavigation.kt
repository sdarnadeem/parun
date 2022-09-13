package dev.nasyxnadeem.parun.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.nasyxnadeem.parun.screens.signin.SigninScreen
import dev.nasyxnadeem.parun.screens.signup.SignupScreen
import dev.nasyxnadeem.parun.screens.signup.SignupViewModel
import dev.nasyxnadeem.parun.screens.splash.SplashScreen

@Composable
fun ParunNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ParunScreens.SplashScreen.name) {


        // Splash Screen
        composable(route = ParunScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        // SignUp Screen
        composable(route = ParunScreens.SignupScreen.name) {
            val viewModel = hiltViewModel<SignupViewModel>()
            SignupScreen(navController = navController, viewModel = viewModel)
        }

        // Signin Screen
        composable(route = ParunScreens.LoginScreen.name) {

            SigninScreen(navController = navController)
        }
    }
}
package dev.nasyxnadeem.parun.navigation

enum class ParunScreens {
    SplashScreen, LoginScreen, SignupScreen, HomeScreen;

    companion object {
        fun fromRoute(route: String?): ParunScreens =
            when (route?.substringBefore("/")) {
                SplashScreen.name ->SplashScreen
                LoginScreen.name -> LoginScreen
                SignupScreen.name -> SignupScreen
                HomeScreen.name -> HomeScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("Route $route is not defined")

            }
    }
}
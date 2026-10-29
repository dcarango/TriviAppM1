package com.iessanalberto.dam2.triviapp.navigation

sealed class AppScreens (val route: String) {
    object MainScreen: AppScreens(route = "main_screen")
    object ParesNonesScreen : AppScreens(route = "paresNones_screen")
    object PiedraPapelTijeraScreen : AppScreens(route = "piedraPapelTijera_screen")
}
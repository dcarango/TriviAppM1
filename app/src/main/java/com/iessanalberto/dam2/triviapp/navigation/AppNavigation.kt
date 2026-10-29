package com.iessanalberto.dam2.triviapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.iessanalberto.dam2.triviapp.screens.MainScreen
import com.iessanalberto.dam2.triviapp.screens.ParesNonesScreen
import com.iessanalberto.dam2.triviapp.screens.PiedraPapelTijeraScreen

@Composable
fun AppNavigation () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MainScreen.route) {

        // Navegacion sin argumentos
        composable (route = AppScreens.MainScreen.route) { MainScreen(navController) }
        composable (route = AppScreens.ParesNonesScreen.route) { ParesNonesScreen(navController) }
        composable (route = AppScreens.PiedraPapelTijeraScreen.route) { PiedraPapelTijeraScreen(navController) }
    }
}
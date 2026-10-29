package com.iessanalberto.dam2.triviapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.iessanalberto.dam2.triviapp.R
import com.iessanalberto.dam2.triviapp.navigation.AppScreens

/*
* Author: Daniel C.
* Date: 13/10/26
* Screen: Menú principal.
* */

@Composable
fun MainScreen (navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter =  painterResource(R.drawable.triviapp),
            contentDescription = "iconoPrincpal"
        )
        Button(
            onClick = { navController.navigate(route = AppScreens.ParesNonesScreen.route) }
        ) {
            Text( text = "Pares o nones")
        }
        Button(
            onClick = { navController.navigate(route = AppScreens.PiedraPapelTijeraScreen.route) }
        ) {
            Text( text = "Piedra papel o tijeras")
        }
    }
}
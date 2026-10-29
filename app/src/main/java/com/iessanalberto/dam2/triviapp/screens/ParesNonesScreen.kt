package com.iessanalberto.dam2.triviapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.iessanalberto.dam2.triviapp.R
import com.iessanalberto.dam2.triviapp.models.ParesONones

/*
* Author: Daniel C.
* Date: 13/10/26
* Screen: Pares o nones, pantalla principal.
*/

@Composable
fun ParesNonesScreen (navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        ParesNonesScreenBody(modifier = Modifier.padding(innerPadding),
            navController = navController)
    }
}

@Composable
fun ParesNonesScreenBody (modifier: Modifier, navController: NavController) {
    // Remembers
    var partidaActual by remember { mutableStateOf<ParesONones?>(null) }
    var opcionEscogida by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter =  painterResource(R.drawable.paresnones),
            contentDescription = "Pares o nones logo"
        )
        // Label
        Text(text = "Escoge una opción:",
            style = MaterialTheme.typography.titleMedium
            )
        // Contenedor
        Row (
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            // Btn pares
            Button(
                onClick = {
                    opcionEscogida = "Pares"
                    partidaActual = ParesONones()
                }
            ) {
                Text(text = "Pares")
            }
            // Btn nones
            Button(
                onClick = {
                    opcionEscogida = "Nones"
                    partidaActual = ParesONones()
                }
            ) {
                Text(text = "Nones")
            }
        }
        partidaActual?.let { juego ->
            CalcularGanador(
                juego = juego,
                opcionEscogida = opcionEscogida,
                navController = navController
            )
        }
    }
}

@Composable
fun CalcularGanador (
    juego: ParesONones,
    opcionEscogida: String,
    navController: NavController
) {
    var esPar = juego.isPar()
    val esGanador = (opcionEscogida == "Pares" && esPar) || (opcionEscogida == "Nones" && !esPar)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(
            text = "El número es generado es: "+juego.numero,
            style = MaterialTheme.typography.titleMedium
        )
        if (esGanador) {
            Text(text = "¡Ganaste!",
                style = MaterialTheme.typography.titleMedium)
       } else {
            Text(text = "¡Perdiste!",
                style = MaterialTheme.typography.titleMedium)
        }
        Button(
            onClick =  {navController.popBackStack()},
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Volver al menú")
        }
    }
}
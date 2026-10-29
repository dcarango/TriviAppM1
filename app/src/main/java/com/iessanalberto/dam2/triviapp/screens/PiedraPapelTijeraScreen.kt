package com.iessanalberto.dam2.triviapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.iessanalberto.dam2.triviapp.models.PiedraPapelTijera

/*
* Author: Daniel C.
* Date: 13/10/26
* Screen: Piedra, papel o tijera - pantalla principal.
*/

@Composable
fun PiedraPapelTijeraScreen (navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        PiedraPapelTijeraBody(modifier = Modifier.padding(innerPadding),
            navController = navController)
    }
}

@Composable
fun PiedraPapelTijeraBody (modifier: Modifier, navController: NavController) {
    // Remembers
    var partidaActual by remember { mutableStateOf<PiedraPapelTijera?>(null) }
    var opcionEscogida by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(24.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment =Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter =  painterResource(R.drawable.piedrapapeltijera),
            contentDescription = "Piedra, papel o tijera logo",
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
            // Btn piedra
            Button(
                onClick = {
                    opcionEscogida = "Piedra"
                    partidaActual = PiedraPapelTijera()
                }
            ) {
                Image(
                    painter =  painterResource(R.drawable.piedra),
                    contentDescription = "escoger piedra",
                    modifier = Modifier.size(44.dp)
                )
            }
            // Btn papel
            Button(
                onClick = {
                    opcionEscogida = "Papel"
                    partidaActual = PiedraPapelTijera()
                }
            ) {
                Image(
                    painter =  painterResource(R.drawable.papel),
                    contentDescription = "escoger papel",
                    modifier = Modifier.size(44.dp)
                )
            }
            // Btn tijera
            Button(
                onClick = {
                    opcionEscogida = "Tijeras"
                    partidaActual = PiedraPapelTijera()
                }
            ) {
                Image(
                    painter =  painterResource(R.drawable.tijeras),
                    contentDescription = "escoger tijeras",
                    modifier = Modifier.size(44.dp)
                )
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
    juego: PiedraPapelTijera,
    opcionEscogida: String,
    navController: NavController
) {
    var opcionCpu = juego.opcionCpu
    var estado = "" // Podría ser un enum

    if (opcionEscogida == opcionCpu) {
        estado = "Empate"
    } else if (opcionEscogida == "Piedra" && opcionCpu == "Tijeras") {
        estado = "Victoria"
    } else if (opcionEscogida == "Papel" && opcionCpu == "Piedra") {
        estado = "Victoria"
    } else if (opcionEscogida == "Tijeras" && opcionCpu == "Papel") {
        estado = "Victoria"
    } else {
        estado = "Derrota"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(
            text = "Tu contrincante escogió: "+juego.opcionCpu,
            style = MaterialTheme.typography.titleMedium
        )
        when (estado) {
            "Victoria" -> {
                Text(
                    text = "¡Ganaste!",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            "Empate" -> {
                Text(
                    text = "¡Empate!",
                    style = MaterialTheme.typography.titleMedium
                )
            }
            else -> {
                Text(
                    text = "¡Perdiste!",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        Button(
            onClick =  {navController.popBackStack()},
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = "Volver al menú")
        }
    }
}
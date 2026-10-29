package com.iessanalberto.dam2.triviapp.models

data class PiedraPapelTijera(
    // Podría ser un Enum pero
    val opciones: Array<String> = arrayOf("Piedra", "Papel", "Tijeras"),
    val opcionCpu: String = opciones.random()
) {

}

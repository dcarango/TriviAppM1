package com.iessanalberto.dam2.triviapp.models

import kotlin.random.Random

data class ParesONones(
    val numero: Int = Random.nextInt(1,101) // O también --> (1..100).random()
) {
    // Funcion que calcula si el número escogido aleatoriamente es par o impar.
    fun isPar(): Boolean {
        return this.numero % 2 == 0
    }
}
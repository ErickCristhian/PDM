package com.erick.expobre

import kotlin.random.Random

object Megasena {

    fun getInstance(): List<Int> {
        var lista = mutableSetOf<Int>()
        var random = Random

        while (lista.size < 6){
            lista.add(random.nextInt(60)+1)
        }
        return lista.toList().sorted()
    }
}
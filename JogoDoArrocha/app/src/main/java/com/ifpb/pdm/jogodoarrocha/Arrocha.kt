package com.example.jogodoarrocha

import kotlin.random.Random

class Arrocha {
    var menor: Int
    var maior: Int
    var numero: Int

    constructor(menor: Int, maior: Int){
        this.menor = menor
        this.maior = maior
        this.numero = Random.nextInt(this.menor + 1, this.maior - 1)
    }

    fun intervalo():String{
        return "${this.menor} - ${this.maior}"
    }

    fun validar(chute: Int): Boolean{
        if (chute == this.numero) return false
        return (chute > this.menor) && (chute < this.maior)
    }

    fun arrochou(): Boolean{
        return (this.menor + 1) == (this.maior - 1)
    }

    fun chutar(chute: Int){
        if (chute < this.numero) this.menor = chute
        else this.maior = chute

    }
}
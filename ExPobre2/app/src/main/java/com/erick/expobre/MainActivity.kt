package com.erick.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var tvNumeros: TextView
    private lateinit var  btRandon: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btRandon = findViewById<Button>(R.id.btRandom)

        this.tvNumeros = findViewById(R.id.tvNumeros)
        this.tvNumeros.text = this.megasena().toString()

        this.btRandon.setOnClickListener() {
            Toast.makeText(this, "button clicked", Toast.LENGTH_LONG).show();
            onClickSortear()
        }
    }

    fun megasena(): List<Int> {
        var lista = mutableSetOf<Int>()
        var random = Random

        while (lista.size < 6){
            lista.add(random.nextInt(60)+1)
        }
        return lista.toList()
    }


    fun onClickSortear() {
        this.tvNumeros = findViewById(R.id.tvNumeros)
        this.tvNumeros.text = this.megasena().toString()
    }
}


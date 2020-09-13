package com.ifpb.pdm.desafio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    private lateinit var tvInfo1: TextView
    private lateinit var tvInfo2: TextView
    private lateinit var tvInfo3: TextView
    private lateinit var tvResult: TextView
    private lateinit var btChutar: Button
    private lateinit var etChute: EditText
    private var n : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvInfo1 = findViewById(R.id.tvInfo01)
        tvInfo2 = findViewById(R.id.tvInfo02)
        tvInfo3 = findViewById(R.id.tvInfo03)
        tvResult = findViewById(R.id.tvResult)
        btChutar = findViewById(R.id.btChutar)
        etChute = findViewById(R.id.etChute)

        genNumber()

        btChutar.setOnClickListener(){
            getNumber()
        }
    }
    private fun getNumber() {
        val x = etChute.text.toString().toIntOrNull()
        tvResult.setText("fdfds")
        if(x == n) {
            var msg = "Parabéns você acertou"
            tvResult.setText(msg)
        } else {
            var msg = " Você errou o número era " + n
            tvResult.setText(msg)
        }
        genNumber()
    }
    private fun genNumber() {
        n = Random.nextInt(1, 100)
        Log.i("APP_ACERTE", n.toString())
        genTips()
    }

    private fun genTips() {
        var divs = 0
        val divsInRange10 = arrayListOf<Int>()

        for (i in 1..10) {
            if (n % i == 0) {
                divsInRange10.add(i)
            }
        }

        tvInfo1.setText("Divisível por " + divsInRange10.joinToString(separator = ", "))

        if (n % 2 == 0) {
            tvInfo2.setText("É par")
        } else {
            tvInfo2.setText("É ímpar")
        }

        for (i in 1..n) {
            if (n % i == 0) {
                divs++
            }
        }

        tvInfo3.setText("Quantidade de divisores: " + divs.toString())
    }
    override fun onRestart() {
        super.onRestart()
        genNumber()
    }
}
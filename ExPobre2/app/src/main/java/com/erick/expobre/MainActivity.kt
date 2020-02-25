package com.erick.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        this.btRandon = findViewById(R.id.btRandom)
        this.tvNumeros = findViewById(R.id.tvNumeros)


        this.tvNumeros.text = Megasena.getInstance().joinToString( " " )
        this.btRandon.setOnClickListener(OnClickBotao())
    }

    inner class OnClickBotao : View.OnClickListener{
        override fun onClick(v: View?) {
            this@MainActivity.tvNumeros.text = Megasena.getInstance().joinToString( " " )
        }

    }
}


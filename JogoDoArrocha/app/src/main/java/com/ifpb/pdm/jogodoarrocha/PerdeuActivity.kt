package com.example.jogodoarrocha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class PerdeuActivity : AppCompatActivity() {
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perdeu)

        this.tvResultado = findViewById(R.id.tvPerdeuResultado)

        this.tvResultado.setOnClickListener{
            finish()
        }
    }
}
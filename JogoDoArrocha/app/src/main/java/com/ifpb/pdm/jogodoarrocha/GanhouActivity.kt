package com.example.jogodoarrocha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GanhouActivity : AppCompatActivity() {
    private lateinit var tvResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ganhou)

        this.tvResultado = findViewById(R.id.tvGanhouResultado)

        this.tvResultado.setOnClickListener{
            finish()
        }
    }
}
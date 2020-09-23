package com.example.jogodoarrocha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import com.ifpb.pdm.jogodoarrocha.R

class MainActivity : AppCompatActivity() {
    private lateinit var tvIntervalo: TextView
    private lateinit var sbChute: SeekBar
    private lateinit var tvChute: TextView
    private lateinit var btChutar: Button
    private lateinit var arrocha: Arrocha

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvIntervalo = findViewById(R.id.tvMainIntervalo)
        this.sbChute = findViewById(R.id.sbMainChute)
        this.tvChute = findViewById(R.id.tvMainChute)
        this.btChutar = findViewById(R.id.btMainChute)

        this.novoJogo()

        this.btChutar.setOnClickListener(ClickBotao())
        this.sbChute.setOnSeekBarChangeListener( ExibeChute() )
    }

    fun novoJogo(){
        this.arrocha = Arrocha(1, 100)
        this.atualiza()
        Log.i("APP_ARROCHA", this.arrocha.numero.toString())
    }

    override fun onRestart() {
        super.onRestart()

        this.novoJogo()
    }

    fun atualiza(){
        this.tvIntervalo.text = this.arrocha.intervalo()
        this.sbChute.progress = 1
        this.tvChute.text = this.arrocha.menor.toString()
    }

    inner class ClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            var chute = this@MainActivity.sbChute.progress
            if (!this@MainActivity.arrocha.validar(chute)){
                val intent = Intent(this@MainActivity, PerdeuActivity::class.java)
                startActivity(intent)
            }else{
                this@MainActivity.arrocha.chutar(chute)
                this@MainActivity.atualiza()
                if (this@MainActivity.arrocha.arrochou()){
                    val intent = Intent(this@MainActivity, GanhouActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    inner class ExibeChute: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@MainActivity.tvChute.text = progress.toString()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }

    }
}
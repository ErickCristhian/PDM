package com.erick.deuruim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var btNovo: Button
    private lateinit var tvResult: TextView
    private lateinit var cadastro: Cadastro
    val FORM = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.btNovo = findViewById(R.id.btNovo)
        this.tvResult = findViewById(R.id.tvResult)
        this.cadastro = Cadastro()

        this.btNovo.setOnClickListener(OnClickBotao())

        this.tvResult.text = this.cadastro.count().toString()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FORM){
                val evento = data?.getParcelableExtra<Evento>("EVENTO")
                Log.i("APP_DEURUIM", evento.toString())

                this.cadastro.add(evento!!)
                this.tvResult.text = this.cadastro.count().toString()
                Log.i("APP_DEURUIM", this.cadastro.get().toString())
            }
        }
    }
    inner class OnClickBotao: View.OnClickListener{
        override fun onClick(v: View?) {
            val intent = Intent(this@MainActivity, EventActivity::class.java)
            startActivityForResult(intent, FORM)
        }
    }
}

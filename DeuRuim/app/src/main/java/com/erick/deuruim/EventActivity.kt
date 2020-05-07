package com.erick.deuruim

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar

class EventActivity : AppCompatActivity() {
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var etDescricao: EditText
    private lateinit var sbNota: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)
        this.etDescricao = findViewById(R.id.etFormDescricao)
        this.sbNota = findViewById(R.id.sbFormSeekbar)

        this.btCancelar.setOnClickListener({
            finish()
        })
        this.btSalvar.setOnClickListener({salvar()})
    }
    fun salvar(){
        val descricao = this.etDescricao.text.toString()
        val nota = this.sbNota.progress

        val evento = Evento(descricao, nota)
        val intent = Intent()
        intent.putExtra("EVENTO", evento)

        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}


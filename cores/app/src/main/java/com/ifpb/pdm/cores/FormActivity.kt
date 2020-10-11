package com.ifpb.pdm.cores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etCodigo: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etNome = findViewById(R.id.etFormNome)
        this.etCodigo = findViewById(R.id.etFormCodigo)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener { salvar(it) }
        this.btCancelar.setOnClickListener { cancelar(it) }
    }

    private fun salvar(view: View){
        val nome = this.etNome.text.toString()
        val codigo = this.etCodigo.text.toString()
        val cor = Cor(nome, codigo)
        val intent = Intent()
        intent.putExtra("COR", cor)
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun cancelar(view: View){
        finish()
    }
}
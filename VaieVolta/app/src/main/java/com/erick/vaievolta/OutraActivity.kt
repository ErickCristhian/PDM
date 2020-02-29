package com.erick.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText

class OutraActivity : AppCompatActivity() {
    private lateinit var btOk: Button
    private lateinit var etMensagem: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra)

        this.btOk = findViewById(R.id.btOutraOk)
        this.etMensagem = findViewById(R.id.etOutraMensagem)
        this.etMensagem.setText(intent.getStringExtra("MENSAGEM"))

        this.btOk.setOnClickListener(OnClickBotao())

    }

    inner class OnClickBotao: View.OnClickListener {
        override fun onClick(v: View?) {
            val it = Intent()
            val msg = this@OutraActivity.etMensagem.text.toString()
            it.putExtra("MENSAGEM_VOLTA", msg)
            setResult(Activity.RESULT_OK, it)
            finish()
        }
    }
}

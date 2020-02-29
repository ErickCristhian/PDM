package com.erick.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btOk: Button
    private lateinit var etMensagem: EditText
    private lateinit var btSobre: Button
    val OUTRA = 1

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btOk = findViewById(R.id.btMainOk)
        this.etMensagem = findViewById(R.id.etMainMensagem)
        this.btSobre = findViewById(R.id.btMainSobre)
        this.btSobre.setOnClickListener(OnCLickSobre())
        this.btOk.setOnClickListener(OnClickBotao())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == OUTRA){
                val msg = data?.getStringExtra("MENSAGEM_VOLTA")
                this.etMensagem.setText(msg)
            }
        }else{
            Toast.makeText(this, "Voltou oelo Dispositivo", Toast.LENGTH_SHORT).show()
        }
    }

    inner class OnCLickSobre: View.OnClickListener{
        override fun onClick(v: View?) {
            val it = Intent(this@MainActivity, SobreActivity::class.java)
            startActivity(it)
        }
    }

    inner class OnClickBotao: View.OnClickListener {
        override fun onClick(v: View?) {
            val it = Intent(this@MainActivity, OutraActivity::class.java)
            val msg = this@MainActivity.etMensagem.text.toString()
            it.putExtra("MENSAGEM", msg)
            startActivityForResult(it, OUTRA)

        }
    }
}

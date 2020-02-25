package com.erick.autentica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var etSenha: EditText
    private lateinit var etUsuario: EditText
    private lateinit var btnCancelar: Button
    private lateinit var btnOk: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.etSenha = findViewById(R.id.etSenha)
        this.etUsuario = findViewById(R.id.etUsuario)
        this.btnCancelar = findViewById(R.id.btnCancelar)
        this.btnOk = findViewById(R.id.btnOk)
        this.btnOk.setOnClickListener(OnClickBotao())

        this.btnCancelar.setOnClickListener(){
            Log.i("APP_AUTENTICA", "i - Cancelou")
            Log.e("APP_AUTENTICA", "e - Cancelou")
            Log.w("APP_AUTENTICA", "w - Cancelou")
            this.etUsuario.text.clear()
            this.etSenha.text.clear()
            Toast.makeText(this, " Voce Cancelou", Toast.LENGTH_LONG).show()
        }
    }

    inner class OnClickBotao: View.OnClickListener{
        override fun onClick(p0: View?) {
            var user = this@MainActivity.etUsuario.text.toString()
            var ps = this@MainActivity.etSenha.text.toString()

            Log.i("APP_AUTENTICA", "i : $user - $ps")

            if(user == "admin" && ps == "1234"){
                Toast.makeText(this@MainActivity, " Sucesso!!!", Toast.LENGTH_LONG).show()
                Log.i("APP_AUTENTICA", "i : Deu Bom")
                setContentView(R.layout.bem_vindo)
            }else{
                Log.i("APP_AUTENTICA", "e : Deu Ruim")
                Toast.makeText(this@MainActivity, " Erro :(", Toast.LENGTH_LONG).show()
            }
        }

    }
}

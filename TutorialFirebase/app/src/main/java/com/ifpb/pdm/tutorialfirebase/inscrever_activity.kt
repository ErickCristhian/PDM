package com.ifpb.pdm.tutorialfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class inscrever_activity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var etEmail: EditText
    private lateinit var etSenha: EditText
    private lateinit var btLogin: Button
    private lateinit var btCriar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inscrever_activity)
        auth = FirebaseAuth.getInstance()
        etEmail = findViewById(R.id.insEmail)
        etSenha = findViewById(R.id.insSenha)
        btLogin = findViewById(R.id.maLogin)
        btCriar = findViewById(R.id.insbtLogin)
        this.btLogin.setOnClickListener(onClickToLogin())
        btCriar.setOnClickListener(onClickLogin())
    }
    inner class onClickToLogin: View.OnClickListener{
        override fun onClick(v: View?){
            val it = Intent(this@inscrever_activity, MainActivity::class.java)
            startActivity(it)
        }
    }
    inner class onClickLogin: View.OnClickListener{
        override fun onClick(v: View?) {
            auth.createUserWithEmailAndPassword(etEmail.toString(), etSenha.toString())
            val it = Intent(this@inscrever_activity, OlaActivity::class.java)
            startActivity(it)
        }
    }
}
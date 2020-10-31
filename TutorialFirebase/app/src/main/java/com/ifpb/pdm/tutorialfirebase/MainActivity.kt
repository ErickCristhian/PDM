package com.ifpb.pdm.tutorialfirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var maEmail: EditText
    private lateinit var maSenha: EditText
    private lateinit var maLogin: Button
    private lateinit var insCriar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()

        insCriar = findViewById(R.id.insbtCriar)
        maEmail = findViewById(R.id.maetEmail)
        maSenha = findViewById(R.id.maetSenha)
        maLogin = findViewById(R.id.mabtLogin)

        insCriar.setOnClickListener(OnClickToCriar())
        maLogin.setOnClickListener(OnClickLogin())

    }

    public override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null) {
            val it = Intent(this@MainActivity, OlaActivity::class.java)
            startActivity(it)
        }
    }
    inner class OnClickToCriar: View.OnClickListener{
        override fun onClick(v: View?) {
            val it = Intent(this@MainActivity, inscrever_activity::class.java)
            startActivity(it)
        }
    }
    inner class OnClickLogin: View.OnClickListener{
        override fun onClick(v: View?) {
            auth.signInWithEmailAndPassword(maEmail.toString(), maSenha.toString())
            val it = Intent(this@MainActivity, OlaActivity::class.java)
            startActivity(it)
        }
    }
}
package com.ifpb.pdm.rgb
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.rgb.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var tvVemelho: TextView
    private lateinit var tvVerde: TextView
    private lateinit var tvAzul: TextView
    private lateinit var receiver: TelaReceiver
    private lateinit var filter: IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvVemelho = findViewById(R.id.tvVermelho)
        this.tvVerde = findViewById(R.id.tvVerde)
        this.tvAzul = findViewById(R.id.tvAzul)

        if (intent.hasExtra(Intent.EXTRA_TEXT)){
            this.tvVermelho.text = intent.getStringExtra(Intent.EXTRA_TEXT)
            this.tvVerde.text = intent.getStringExtra(Intent.EXTRA_TEXT)
            this.tvAzul.text = intent.getStringExtra(Intent.EXTRA_TEXT)
        }else if (intent.hasExtra("URL")){
            this.tvVermelho.text = "IFPB"
            this.tvVerde.text = "IFPB"
            this.tvAzul.text = "IFPB"
            Toast.makeText(this, intent.getStringExtra("URL"), Toast.LENGTH_SHORT).show()
        }

        this.criarReceiver()
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(this.receiver, this.filter)
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(this.receiver)
    }

    private fun criarReceiver(){
        this.receiver = TelaReceiver()
        this.filter = IntentFilter()
        this.filter.addAction(Intent.ACTION_USER_PRESENT)
    }

    inner class TelaReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            this@MainActivity.tvVermelho.text = "Red"
            this@MainActivity.tvVerde.text = "Green"
            this@MainActivity.tvAzul.text = "Blue"
        }
    }
}
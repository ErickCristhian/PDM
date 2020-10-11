package com.ifpb.pdm.cores

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.ListView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var lvCores: ListView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var lista: ArrayList<Cor>
    val FORMULARIO = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lista = ArrayList()

        this.lvCores = findViewById(R.id.lvCores)
        this.fabAdd = findViewById(R.id.fabAdd)

        //this.lvCores.adapter = ArrayAdapter<Cor>(this, android.R.layout.simple_list_item_1, this.lista)
        this.lvCores.adapter = CorAdapter(this, this.lista)

        this.fabAdd.setOnClickListener { add(it) }

        this.lvCores.setOnItemLongClickListener( ClickLongo() )
    }

    private fun add(view: View){
        val intent = Intent(this, FormActivity::class.java)
        startActivityForResult(intent, FORMULARIO)
    }

    private fun atualiza(){
        (this.lvCores.adapter as BaseAdapter).notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK){
            if (requestCode == FORMULARIO){
                val cor = data?.getSerializableExtra("COR") as Cor
                this.lista.add(cor)
                this.atualiza()
            }
        }
    }

    inner class ClickLongo: AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ): Boolean {
            this@MainActivity.lista.removeAt(position)
            this@MainActivity.atualiza()
            return true
        }
    }
}

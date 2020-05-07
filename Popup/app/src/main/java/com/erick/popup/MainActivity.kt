package com.erick.popup

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var btMensagem: Button
    private lateinit var btInput: Button
    private lateinit var btData: Button
    private lateinit var btHora: Button
    private lateinit var btValores: Button
    private lateinit var btEscolha: Button
    private lateinit var btUnico: Button
    private lateinit var btVarios: Button
    private  lateinit var view: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btMensagem = findViewById(R.id.btMensagem)
        this.btInput = findViewById(R.id.btInput)
        this.btData = findViewById(R.id.btData)
        this.btHora = findViewById(R.id.btHora)
        this.btValores = findViewById(R.id.btValores)
        this.btEscolha = findViewById(R.id.btEscolha)
        this.btUnico = findViewById(R.id.btUnico)
        this.btVarios = findViewById(R.id.btVários)

        this.btMensagem.setOnClickListener({mensagem()})
        this.btInput.setOnClickListener({input()})
        this.btData.setOnClickListener({data()})
        this.btHora.setOnClickListener({hora()})
        this.btValores.setOnClickListener({valores()})
        this.btEscolha.setOnClickListener({escolha()})
        this.btUnico.setOnClickListener({unico()})
        this.btVarios.setOnClickListener({varios()})
    }
    fun mensagem(){
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.mipmap.ic_launcher)
        builder.setTitle("Mensagem")
        builder.setMessage("Que bom")
        builder.setPositiveButton("OK"){
            dialog, which ->
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
            dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Genérico"){
            dialog, which ->
            Toast.makeText(this, "Genérico", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
    fun input(){
        val builder = AlertDialog.Builder(this)
        this.view = EditText(this)
        builder.setTitle("Input")
        builder.setView(this.view)
        builder.setPositiveButton("OK"){
                dialog, which ->
            val mensagem = (this.view as EditText).text.toString()
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
                dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
    fun data(){
        val builder = AlertDialog.Builder(this)
        this.view = DatePicker(this)

        builder.setTitle("DatePicker")
        builder.setMessage("Escolha uma data")
        builder.setView(this.view)

        builder.setPositiveButton("OK"){
                dialog, which ->
            val dp = this.view as DatePicker
            val msg = "${dp.dayOfMonth}/${dp.month + 1}/${dp.year}"
            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
                dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
    fun hora(){
        val builder = AlertDialog.Builder(this)
        this.view = TimePicker(this)

        builder.setTitle("DatePicker")
        builder.setMessage("Escolha uma data")
        builder.setView(this.view)

        builder.setPositiveButton("OK"){
                dialog, which ->
            val tp = this.view as TimePicker
            var msg = ""
            if(Build.VERSION.SDK_INT < 23){
                msg = "${tp.currentHour}:${tp.currentMinute}"
            }else {
                val msg = "${tp.hour}:${tp.minute}"
            }

            Toast.makeText(this, "Ok", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
                dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }

    fun valores(){
        val builder = AlertDialog.Builder(this)
        this.view = SeekBar(this)

        builder.setTitle("SeekBar")
        builder.setMessage("Escolha um valor")
        builder.setView(this.view)

        builder.setPositiveButton("OK"){
                dialog, which ->
            val sb = this.view as SeekBar
            sb.max = 100

            Toast.makeText(this, sb.progress.toString(), Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
                dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
    fun escolha(){
        val builder = AlertDialog.Builder(this)
        this.view = Switch(this)

        builder.setTitle("Switch")
        builder.setMessage("Verdadeiro ou Falso?")
        builder.setView(this.view)

        builder.setPositiveButton("OK"){
                dialog, which ->
            val sw = this.view as Switch


            Toast.makeText(this, sw.isChecked.toString(), Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
                dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
    fun unico(){
        val builder = AlertDialog.Builder(this)
        this.view = RadioGroup(this)
        val radio = listOf("Eu", "Tu", "Nós")
        for (option in radio){
            val button = RadioButton(this)
            button.text=option
            button.id = radio.indexOf(option)
            (this.view as RadioGroup).addView(button)
        }

        builder.setTitle("Radio")
        builder.setMessage("Escolha")
        builder.setView(this.view)

        builder.setPositiveButton("OK"){
                dialog, which ->
            val rd = (this.view as RadioGroup).findViewById<RadioButton>((this.view as RadioGroup).checkedRadioButtonId)?.text.toString()
            if(rd != "null"){
                Toast.makeText(this, rd, Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Nenhuma opção marcada", Toast.LENGTH_SHORT).show()
            }
        }
        builder.setNegativeButton("Cancel"){
                dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
    fun varios(){
        val builder = AlertDialog.Builder(this)
        this.view = LinearLayout(this)
        val radio = listOf("Eu", "Tu", "Nós")
        for (option in radio){
            val button = RadioButton(this)
            button.text=option
            button.id = radio.indexOf(option)
            (this.view as LinearLayout).addView(button)
        }

        builder.setTitle("CheckBox")
        builder.setMessage("Escolha:")
        builder.setView(this.view)

        builder.setPositiveButton("OK"){
                dialog, which ->
            val rd = (this.view as RadioGroup).checkedRadioButtonId
            val msg = radio[rd]


            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("Cancel"){
                dialog, which ->
            Toast.makeText(this, "Cancelar", Toast.LENGTH_SHORT).show()
        }
        builder.create().show()
    }
}

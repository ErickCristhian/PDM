package com.example.imagens

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import java.net.URL

class MainActivity : AppCompatActivity() {
    private lateinit var btCamera: Button
    private lateinit var btXML: Button
    private lateinit var btDownload: Button
    private lateinit var ivImagem: ImageView
    val CAMERA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btCamera = findViewById(R.id.btCamera)
        this.btXML = findViewById(R.id.btXml)
        this.btDownload = findViewById(R.id.btDownload)
        this.ivImagem = findViewById(R.id.ivImagem)

        this.btCamera.setOnClickListener({camera()})
        this.btXML.setOnClickListener({xml()})
        this.btDownload.setOnClickListener({download()})
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK)
            if (requestCode == CAMERA){
                val imagem = data?.extras?.get("data") as Bitmap
                this.ivImagem.setImageBitmap(imagem)
            }
    }
    fun camera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(intent, CAMERA)
    }
    fun xml(){
        this.ivImagem.setImageResource(R.drawable.super_mario)
    }
    fun downloadDaImagem(url: String) : Bitmap{
        URL(url).openStream().use {
            val imagem = BitmapFactory.decodeStream(it)
            return imagem
        }
    }
    fun download(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Escolha o tamanho da Imagem")
        val options = arrayOf("hdpi", "ldpi", "mdpi", "xhdpi", "xxhdpi", "xxxhdpi")
        builder.setSingleChoiceItems(options,0) {
            dialog: DialogInterface, which: Int ->
                getOption(dialog, which, options)
        }
        builder.setNegativeButton("Cancel", null)
        builder.create().show()
    }
    fun getOption(D: DialogInterface, i: Int, option: Array<String>){
        val x = option[i]
        D.dismiss()
        Log.i("APP_MESSAGE", x.toString())

        val handler = Handler()
        Thread{
            val imagem = this.downloadDaImagem("http://www.valeria.eti.br/sm/sm_" + x.toString() + ".png")
            handler.post{
                this.ivImagem.setImageBitmap(imagem)
            }

        }.start()

    }
}

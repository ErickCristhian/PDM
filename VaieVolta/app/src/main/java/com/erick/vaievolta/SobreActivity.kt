package com.erick.vaievolta

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class SobreActivity : AppCompatActivity() {
    private lateinit var ivImg: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre)

        this.ivImg = findViewById(R.id.ivSobreImg)
        this.ivImg.setOnClickListener(OnClickBotao())
    }

    inner class OnClickBotao: View.OnClickListener {
        override fun onClick(v: View?) {
            finish()
        }
    }
}

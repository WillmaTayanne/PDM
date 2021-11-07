package com.example.pratica_03

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


class MainActivity : AppCompatActivity() {

    private lateinit var boxColor: LinearLayout
    private lateinit var mensagem: TextView
    private lateinit var bntnovacor: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.boxColor = findViewById(R.id.boxColor)
        this.mensagem = findViewById(R.id.tvMainMensagem)
        this.bntnovacor = findViewById(R.id.mainBntNova)

        this.bntnovacor.setOnClickListener{

            val intent = Intent(this, tela02::class.java)

            startActivity(intent)

        }

        val intent: Intent = intent;
        if (intent != null) {
            val newColor = intent.getStringExtra("NEW_COLOR");
            if(newColor != null) {
                this.mensagem.setText(newColor);
                this.boxColor.setBackgroundColor(  Color.parseColor(newColor) );
            }
        }
    }

}
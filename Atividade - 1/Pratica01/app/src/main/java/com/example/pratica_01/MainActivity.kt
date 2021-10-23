package com.example.pratica_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textViewMensagem: TextView
    private lateinit var btTroca: Button
    private lateinit var tela: View


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.textViewMensagem = findViewById (R.id.tvMensagem)

        this.textViewMensagem.text = Cores().toString()

        this.btTroca = findViewById(R.id.bntTroca)
        this.tela = findViewById(R.id.view)

        this.btTroca.setOnClickListener{
            this.textViewMensagem.text = Cores().toString()

            this.tela.setBackgroundColor(Cores().toString().replace("[","").replace("]","").toInt())

        }





    }



}
package com.example.pratica_02

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var seekBar1: SeekBar
    private lateinit var seekBar2: SeekBar
    private lateinit var seekBar3: SeekBar
    private lateinit var tela: View
    private  lateinit var corgerada: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.seekBar1 = findViewById(R.id.seekBar1)
        this.seekBar1.setOnSeekBarChangeListener(OnChange())

        this.seekBar2 = findViewById(R.id.seekBar2)
        this.seekBar2.setOnSeekBarChangeListener(OnChange())

        this.seekBar3 = findViewById(R.id.seekBar3)
        this.seekBar3.setOnSeekBarChangeListener(OnChange())

        this.tela = findViewById(R.id.tvColor)

        this.tela.setBackgroundColor(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress))

        this.corgerada = findViewById(R.id.tvColorGenetation)
        this.corgerada.setText(java.lang.Integer.toHexString(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress)).substring(2,8).toUpperCase())

    }

    // monitoramento
     inner class OnChange:SeekBar.OnSeekBarChangeListener { // o que deve ser feito quando alterar o valor da seekbar
        private lateinit var tela: View
        private lateinit var seekBar1: SeekBar
        private lateinit var seekBar2: SeekBar
        private lateinit var seekBar3: SeekBar
        private  lateinit var corgerada: TextView

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { // toda vez que alterar faz
            this.tela = findViewById(R.id.tvColor)
            this.seekBar1 = findViewById(R.id.seekBar1)
            this.seekBar2 = findViewById(R.id.seekBar2)
            this.seekBar3 = findViewById(R.id.seekBar3)
            this.corgerada = findViewById(R.id.tvColorGenetation)

            this.tela.setBackgroundColor(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress))

            this.corgerada.setText(java.lang.Integer.toHexString(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress)).substring(2,8).toUpperCase())

        }

         override fun onStartTrackingTouch(seekBar: SeekBar?) {

         }

         override fun onStopTrackingTouch(seekBar: SeekBar?) {

         }
     }




}


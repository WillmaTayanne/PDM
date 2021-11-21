package com.example.pratica06

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class tela02 : AppCompatActivity() {

    private lateinit var seekBar1: SeekBar
    private lateinit var seekBar2: SeekBar
    private lateinit var seekBar3: SeekBar
    private lateinit var tela: View
    private lateinit var corgerada: TextView
    private lateinit var layout: LinearLayout
    private lateinit var bntsalvar: Button
    private lateinit var bntcancelar: Button
    private lateinit var editTextName: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela02)

        this.layout = findViewById(R.id.layoutTela02)
        this.bntsalvar = findViewById(R.id.bntsalvar)
        this.bntcancelar = findViewById(R.id.bntcancelar)
        this.editTextName = findViewById(R.id.editTextName)

        this.bntsalvar.setOnClickListener{

            if(!editTextName.getText().trim().isBlank()) {
                val intent = Intent(this, MainActivity::class.java).apply {
                    val newColor = corgerada.getText().toString() + "/" + editTextName.getText().trim().toString()
                    putExtra("NEW_COLOR", newColor);
                }
                startActivity(intent)
            }

        }

        this.bntcancelar.setOnClickListener {
            this.finish()
        }

        this.seekBar1 = findViewById(R.id.seekBar1)
        this.seekBar1.setOnSeekBarChangeListener(OnChange())

        this.seekBar2 = findViewById(R.id.seekBar2)
        this.seekBar2.setOnSeekBarChangeListener(OnChange())

        this.seekBar3 = findViewById(R.id.seekBar3)
        this.seekBar3.setOnSeekBarChangeListener(OnChange())

        this.tela = findViewById(R.id.tvColor)

        this.tela.setBackgroundColor(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress))

        this.corgerada = findViewById(R.id.tvColorGenetation)
        this.corgerada.setText("#" + java.lang.Integer.toHexString(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress)).substring(2,8).uppercase())
    }

    // monitoramento
    inner class OnChange:SeekBar.OnSeekBarChangeListener { // o que deve ser feito quando alterar o valor da seekbar
        private lateinit var tela: View
        private lateinit var seekBar1: SeekBar
        private lateinit var seekBar2: SeekBar
        private lateinit var seekBar3: SeekBar
        private lateinit var corgerada: TextView
        private lateinit var textViewRed: TextView
        private lateinit var textViewGreen: TextView
        private lateinit var textViewBlue: TextView

        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) { // toda vez que alterar faz
            this.tela = findViewById(R.id.tvColor)
            this.seekBar1 = findViewById(R.id.seekBar1)
            this.seekBar2 = findViewById(R.id.seekBar2)
            this.seekBar3 = findViewById(R.id.seekBar3)
            this.corgerada = findViewById(R.id.tvColorGenetation)

            this.tela.setBackgroundColor(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress))

            this.corgerada.setText("#" + java.lang.Integer.toHexString(Color.rgb(this.seekBar1.progress, seekBar2.progress, seekBar3.progress)).substring(2,8).toUpperCase())

            this.textViewRed = findViewById(R.id.textViewRed)
            this.textViewGreen = findViewById(R.id.textViewGreen)
            this.textViewBlue = findViewById(R.id.textViewBlue)

            this.textViewRed.text = this.seekBar1.progress.toString()
            this.textViewGreen.text = this.seekBar2.progress.toString()
            this.textViewBlue.text = this.seekBar3.progress.toString()

        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {}

        override fun onStopTrackingTouch(seekBar: SeekBar?) {}
    }


}
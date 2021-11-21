package com.example.pratica06

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.core.view.children

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var buttonAdd: Button
    private lateinit var dao: DAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.listView = findViewById(R.id.listView)
        this.listView.setOnItemLongClickListener { parent, view, position, id -> clickItem(parent,view,position,id) }
        this.dao = DAO(this)
        this.atualiza()

        this.buttonAdd = findViewById(R.id.button)
        this.buttonAdd.setOnClickListener {
            val intent = Intent(this, tela02::class.java)
            startActivity(intent)
        }

        val intent: Intent = intent;
        if (intent != null) {
            val newColor = intent.extras?.getString("NEW_COLOR");
            if(newColor != null) {
                val colorCode = newColor.replaceFirst("/"," ").split(" ")[0]
                val colorName = newColor.replaceFirst("/"," ").split(" ")[1]
                val cor = Cor(colorName,colorCode)

                this.salvar(cor)
            }
        }
    }

    private fun salvar(cor: Cor) {
        this.dao.insert(cor)
        this.atualiza()
    }

    private fun atualiza() {
        val list = this.dao.get()
        this.listView.adapter = CorAdapter(this, list)
    }

    fun clickItem(parent: AdapterView<*>?, view: View?, position: Int, id: Long): Boolean {
        val idItem = listView.adapter.getItemId(position)
        dao.delete(idItem)
        atualiza()
        return true
    }

}
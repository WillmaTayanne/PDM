package com.example.pratica06

import android.graphics.Color

var CODIGO = 0L

class Cor {

    var id: Long
    var nome: String
    var codigo: String

    constructor(id: Long, nome: String, codigo: String){
        this.id = id
        this.nome = nome
        this.codigo = codigo
    }

    constructor(nome: String, codigo: String){
        this.id = ++CODIGO
        this.nome = nome
        this.codigo = codigo
    }

    fun color(): Int{
        return Color.parseColor(this.codigo)
    }
}
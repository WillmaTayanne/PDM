package com.example.pratica06

import android.content.ContentValues
import android.content.Context

class DAO {
    private var banco: BancoHolper

    constructor(context: Context) {
        this.banco = BancoHolper(context)
    }

    fun insert (cor: Cor) {
        val cv =  ContentValues()
        cv.put ("nome", cor.nome)
        cv.put ("codigo", cor.codigo)

        this.banco.writableDatabase.insert("cores", null, cv)
    }

    fun count(): Int {
        var sql = "select count(id) from cores"
        val cursor = this.banco.readableDatabase.rawQuery(sql, null)

        cursor.moveToFirst()

        return cursor.getInt(0)
    }


    fun get(): ArrayList<Cor> {
        val lista = ArrayList<Cor> ()
        val colunas = arrayOf("id", "nome", "codigo")
        val cursor = this.banco.readableDatabase.query("cores", colunas, null, null, null, null, "id")

        cursor.moveToFirst()

        for (i in 1..cursor.count){
            val id = cursor.getLong(0)
            val nome = cursor.getString(1)
            val codigo = cursor.getString(2)
            lista.add(Cor(id, nome, codigo))
            cursor.moveToNext()
        }

        return lista


    }

    fun find(id: Int): Cor?{
        val colunas = arrayOf("id", "nome", "codigo")
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        val cursor = this.banco.readableDatabase.query("cores", colunas, where, pWhere, null, null, null)
        cursor.moveToFirst()
        if (cursor.count == 1){
            val id = cursor.getLong(0)
            val nome = cursor.getString(1)
            val codigo = cursor.getString(2)
            return Cor(id, nome, codigo)
        }
        return null
    }

    fun update(cor: Cor){
        val where = "id = ?"
        val pWhere = arrayOf(cor.id.toString())

        val cv = ContentValues()
        cv.put("nome", cor.nome)
        cv.put("codigo", cor.codigo)

        this.banco.writableDatabase.update("cores", cv, where, pWhere)
    }

    fun delete(id: Long){
        val where = "id = ?"
        val pWhere = arrayOf(id.toString())
        this.banco.writableDatabase.delete("cores", where, pWhere)
    }
}
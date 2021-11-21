package com.example.pratica06

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class BancoHolper (context: Context): SQLiteOpenHelper(context, "bd_cores", null, 1) {

    override fun onCreate (db:  SQLiteDatabase?) {
        var sql = "create table cores( " +
                    "id integer primary key autoincrement, " +
                    "nome text, " +
                    "codigo text) "

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL ("drop table cores")
            this.onCreate(db)
    }
}
package com.example.pratica_01

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random


class Cores {

    private var cores: MutableSet<Int>

    constructor() {
        this.cores = mutableSetOf()
        this.setCores()
    }

    private fun setCores() {

        val color = Color.argb(255, Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
        cores.add(color)

    }

    override fun toString(): String {
        return this.cores.toString()
    }

}

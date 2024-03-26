package com.example.android_exercise_1

import kotlin.random.Random

object Game {
    private val elephant = "ELEPHANT"
    private val ant = "ANT"
    private val human = "HUMAN"

    private val hero = listOf(elephant, ant, human)

    private val heroDrawable = mapOf(
        "$elephant" to R.drawable.elephant,
        "$ant" to R.drawable.ant,
        "$human" to R.drawable.human
    )

    // Aturan game
    private val rules = mapOf(
        "$elephant-$human" to true,
        "$elephant-$ant" to false,
        "$ant-$elephant" to true,
        "$ant-$human" to false,
        "$human-$ant" to true,
        "$human-$elephant" to false
    )

    fun pickDrawable(option: String): Int? = heroDrawable[option] // Mengambil gambar untuk hero

    fun pickRandom(): String = hero[Random.nextInt(from = 0, 3)]  // Mengambil pilihan random

    fun isDraw(player: String, computer: String) = player == computer  // jika hasil seri

    fun isWin(player: String, computer: String): Boolean? = rules["$player-$computer"]  // function battle


}
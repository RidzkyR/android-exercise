package com.example.android_exercise_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity() {
    lateinit var iv_computer : ImageView
    lateinit var ib_elephant: ImageButton
    lateinit var ib_ant: ImageButton
    lateinit var ib_human: ImageButton
    lateinit var iv_result: ImageView

    private fun iniComponent(){
        iv_computer = findViewById(R.id.iv_computer)
        ib_elephant = findViewById(R.id.ib_elephant)
        ib_ant = findViewById(R.id.ib_ant)
        ib_human = findViewById(R.id.ib_human)
        iv_result = findViewById(R.id.iv_result)
    }

    // inisialisasi listener untuk setiap hero
    private fun initListener(){
        ib_elephant.setOnClickListener{
            startGame("ELEPHANT")
        }
        ib_ant.setOnClickListener{
            startGame("ANT")
        }
        ib_human.setOnClickListener{
            startGame("HUMAN")
        }
    }

    private fun startGame(option: String){
        // computer mengambil option heronya
        val computer = Game.pickRandom()
        Game.pickDrawable(computer)?.let { iv_computer.setImageResource(it) }

        when{
            Game.isWin(option, computer) == true -> iv_result.setImageResource(R.drawable.winner)
            Game.isDraw(option, computer) -> iv_result.setImageResource(R.drawable.draw)
            else -> iv_result.setImageResource(R.drawable.loser)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        iniComponent()
        initListener()

    }
}
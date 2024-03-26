package com.example.andoid_exercises_2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var edtAlas: EditText
    private lateinit var edtTinggi: EditText
    private lateinit var btnPencet: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtAlas = findViewById(R.id.edtAlas)
        edtTinggi = findViewById(R.id.edtTinggi)
        btnPencet = findViewById(R.id.btnPencet)
        tvResult = findViewById(R.id.tvResult)

        btnPencet.setOnClickListener{
            var alas = edtAlas.text.toString().trim()
            var tinggi = edtTinggi.text.toString().trim()

            when{
                alas.isEmpty() -> edtAlas.error = "ISI BRO"
                tinggi.isEmpty() -> edtTinggi.error = "ISI BRO"
                else -> {
                    var luas = ( alas.toDouble() * tinggi.toDouble() ) / 2
                    tvResult.text = luas.toString()
                }
            }

        }
    }
}

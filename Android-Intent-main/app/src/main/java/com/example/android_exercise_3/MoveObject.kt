package com.example.android_exercise_3

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MoveObject : AppCompatActivity() {
    lateinit var tvObject: TextView

    companion object {
        const val EXTRA_OBJECT = "extra_object"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_move_object)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvObject = findViewById(R.id.tv_object)

        // Memeriksa SDK nya apa (karena jika di >= 33 (Tiramisu) pemnaggilannya beda)
        val data = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Data>(EXTRA_OBJECT, Data::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Data>(EXTRA_OBJECT)
        }

        // memasukan data ke textview
        if (data != null) {
            val text = "Name : ${data.name.toString()},\n AGE: ${data.age}"
            tvObject.text = text
        }

    }
}
package com.example.android_pratice_recyleview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // inimah contoh data aja
        val names = listOf("JOKO", "THINKKIR", "LALA", "YEYE", "THINKKIR", "LALA", "YEYE", "THINKKIR", "LALA", "YEYE")
        // ambil adapter
        val mainAdapter = MainAdapter(names)
        findViewById<RecyclerView>(R.id.rv_main).adapter = mainAdapter
    }
}
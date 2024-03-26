package com.example.android_exercise_3

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_exercise_3.MoveObject.Companion.EXTRA_OBJECT

class MainActivity : AppCompatActivity(){
    lateinit var btnExplisit: Button
    lateinit var btnExplisitData: Button
    lateinit var btnExplisitObject: Button
    lateinit var btnImplisit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnExplisit = findViewById(R.id.btnExplisit)
        btnExplisitData = findViewById(R.id.btnExplisitData)
        btnExplisitObject = findViewById(R.id.btnExplisiObject)
        btnImplisit = findViewById(R.id.btnImplisit)


        // pindah tanpa data
        btnExplisit.setOnClickListener {
            val moveActivity = Intent(this@MainActivity, MoveActivity::class.java)
            startActivity(moveActivity)
        }

        // mengirim single data
        btnExplisitData.setOnClickListener {
            val moveActivityData = Intent(this@MainActivity, MoveActivityData::class.java)
            moveActivityData.putExtra(MoveActivityData.EXTRA_NAME, "RAHIM")
            startActivity(moveActivityData)
        }

        // mengirim banyak data
        btnExplisitObject.setOnClickListener {
            val data = Data(
                "RAHIM",
                22
            )

            val moveActivityData = Intent(this@MainActivity, MoveObject::class.java)
            moveActivityData.putExtra(EXTRA_OBJECT, data)
            startActivity(moveActivityData)
        }

        //Implisit
        btnImplisit.setOnClickListener {
            val text = "HAHAHHAHAHA"
            val moveImplisit = Intent(Intent.ACTION_SEND)
            moveImplisit.type = "text/plain"
            moveImplisit.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(moveImplisit)
        }

    }
}
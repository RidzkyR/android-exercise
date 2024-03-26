package com.example.learning_android

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() { //AppCompactActivity -> turunan class Activity agar fitur baru android bisa dijalankan di versi lama

    // Programmatic cek untuk application avaibility
    fun checkCompability(){
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Log.i("CEK","Camera is Available")
        }else{
            Log.w("CEK", "Camera is not Available")
        }
    }

    // Best Pratice untuk inisialisasi komponen View
    private lateinit var tvName: TextView
    private lateinit var edName: EditText
    private lateinit var btnSayHello: Button
    private lateinit var result: TextView

    private fun initComponent(){
        tvName = findViewById(R.id.tv_name)
        edName = findViewById(R.id.ed_name)
        btnSayHello = findViewById(R.id.btn_sayHello)
        result = findViewById(R.id.tv_result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_android)

        checkCompability() // memanggil funsi cek
        initComponent() // memanggil fun inisialisasi

        btnSayHello.setOnClickListener {
            val name = edName.text.toString().toUpperCase()
            result.text = getString(R.string.resultSayHello, name) // Best practice tidak menggunakan Hardcode

            //mencoba string array menggunakan resource
            resources.getStringArray(R.array.names).forEach {
                Log.i("TEST", it)
            }
        }


    }
}
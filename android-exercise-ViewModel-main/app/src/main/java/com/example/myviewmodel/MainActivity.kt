package com.example.myviewmodel

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels() // delegate function yang ada pada library activty-ktx (ada huruf "s" hati hati)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        displayResult()

        binding.btnCalculate.setOnClickListener {
            // mengubah agar masukannya String dulu
            val lebar = binding.edtWidth.text.toString()
            val tinggi = binding.edtHeight.text.toString()
            val panjang = binding.edtLength.text.toString()

            when {
                lebar.isEmpty() -> binding.edtWidth.error = "NDAK BOLEH KOSONG"
                tinggi.isEmpty() -> binding.edtHeight.error = "NDAK BOLEH KOSONG"
                panjang.isEmpty() -> binding.edtLength.error = "NDAK BOLEH KOSONG"
                else -> {
                    viewModel.hitung(lebar, tinggi, panjang)
                    displayResult()
                }
            }
        }
    }

    private fun displayResult() {
        binding.tvResult.text = viewModel.result.toString()
    }
}
package com.example.myviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var result = 0
    fun hitung(lebar: String, tinggi: String, panjang: String){
        result = lebar.toInt() * tinggi.toInt() * panjang.toInt()
    }
}
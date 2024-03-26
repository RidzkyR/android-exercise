package com.example.android_exercise_fragment

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_exercise_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Memanggil Fragment ke activity
        val fragmentManager = supportFragmentManager // memberi akses activity untuk mewadahi fragment
        val homeFragment = HomeFragment()
        val fragment = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName) // memanggil fragment mana yang aka digunakan

        if (fragment !is HomeFragment) {
            Log.d("Test Fragment", "Fragment Name :" + HomeFragment::class.java.simpleName)
            fragmentManager
                .beginTransaction() // memulai fragment
                .add(R.id.frame_container,homeFragment, HomeFragment::class.java.simpleName) // fragment mana yang mau dijalankan
                .commit() // go jalankan
        }

    }
}
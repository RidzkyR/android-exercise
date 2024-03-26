package com.example.android_exercise_api

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputBinding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.android_exercise_api.databinding.ActivityMainBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }

    // mengambil data API
    private fun getRandomQuote() {
        binding.progressBar.visibility = View.VISIBLE // mengatur tampilan progress bar
        // get data menggunakan LoopJ
        val client = AsyncHttpClient() // // koneksi ke server secara asynchronous
        val url = "https://quote-api.dicoding.dev/random" // url API

        // mengabil data API menggunakan LoopJ dengan parsing data
        client.get(url, object : AsyncHttpResponseHandler() {
            // jika koneksi API sukses
            override fun onSuccess(p0: Int, p1: Array<out Header>, p2: ByteArray) {
                binding.progressBar.visibility = View.INVISIBLE

                val result = String(p2)
                Log.d(TAG, result)
                // disini mulai pengambilannya
                try {
                    val responsObject = JSONObject(result)

                    val quote = responsObject.getString("en") // ambil data dengan key en pada API
                    val author = responsObject.getString("author") // ambil data dengan key author pada API

                    binding.tvQuote.text = quote
                    binding.tvAuthor.text = author

                } catch (e: Exception) {
                    Toast.makeText(this@MainActivity, e.message, Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }


            }

            // jika koneksi API gagal
            override fun onFailure(p0: Int, p1: Array<out Header>, p2: ByteArray, p3: Throwable) { // parameter boleh diubah namanya
                binding.progressBar.visibility = View.VISIBLE

                val errorMessage = when(p0){
                    401 -> "$p1 : Bad Request"
                    403 -> "$p1 : Forbidden"
                    404 -> "$p1 : Not Found"
                    else -> "$p1 : ${p3.message}"
                }

                Toast.makeText(this@MainActivity,errorMessage,Toast.LENGTH_SHORT).show()
            }

        })


    }

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

        binding.btnAllQuotes.setOnClickListener {
            startActivity(Intent(this@MainActivity,ListQuotesActivity::class.java))
        }

        getRandomQuote()
    }
}
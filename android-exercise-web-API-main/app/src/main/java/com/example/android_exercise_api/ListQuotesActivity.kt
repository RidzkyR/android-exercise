package com.example.android_exercise_api

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_exercise_api.databinding.ActivityListQuotesBinding
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject

class ListQuotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListQuotesBinding

    companion object {
        private val TAG = ListQuotesActivity::class.java.simpleName
    }

    private fun getListQuote() {
        binding.progressBar.visibility = View.VISIBLE
        val client = AsyncHttpClient()
        val url = "https://quote-api.dicoding.dev/list"

        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(p0: Int, p1: Array<out Header>, p2: ByteArray) {
                binding.progressBar.visibility = View.INVISIBLE

                val listQuotes = ArrayList<String>() //inisialisasi array
                val result = String(p2)
                Log.d(TAG, result)

                try {
                    val jsonArray = JSONArray(result)

                    //pengulangan untuk menampilkan data
                    for (i in 0 until jsonArray.length()){ // penggunaan until  mengambil data dari indeks 0 hingga length -1 (karena penghitungannya mengguankan indeks dari [0])
                        val jsonObject = jsonArray.getJSONObject(i)
                        val quote = jsonObject.getString("en")
                        val author = jsonObject.getString("author")
                        listQuotes.add("\\n$quote\\n — $author\\n")
                    }
                    // menampilkan data ke recyleView
                    val adapter = QuoteAdapter(listQuotes)
                    binding.listQuotes.adapter = adapter
                }catch (e:Exception){
                    Toast.makeText(this@ListQuotesActivity,e.message,Toast.LENGTH_SHORT).show()
                    e.printStackTrace()
                }


            }

            override fun onFailure(p0: Int, p1: Array<out Header>, p2: ByteArray, p3: Throwable) {
                binding.progressBar.visibility = View.VISIBLE

                val errorMessage = when (p0) {
                    401 -> "$p1 : Bad Request"
                    403 -> "$p1 : Forbidden"
                    404 -> "$p1 : Not Found"
                    else -> "$p1 : ${p3.message}"
                }

                Toast.makeText(this@ListQuotesActivity, errorMessage, Toast.LENGTH_SHORT).show()
            }

        })


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layoutManager = LinearLayoutManager(this)
        binding.listQuotes.setLayoutManager(layoutManager)
        val itemDecoration = DividerItemDecoration(this, layoutManager.orientation)
        binding.listQuotes.addItemDecoration(itemDecoration)

        getListQuote()

    }


}
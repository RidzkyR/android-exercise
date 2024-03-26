package com.example.restaurantreview.data.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiConfig {
    companion object{
        fun getApiService(): ApiService{

            /*
            // digunakan jika sudah publish agar pesan log hanya akan tampil pada mode debug
            val loggingInterceptor = if(BuildConfig.DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }
            */

            // inisialisasi logging interceptor dengan level BODY

            val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            // memanggil okHttpClient untuk melakukan request ke server API.
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            // memanggil retrofit
            val retrofit = Retrofit.Builder()
                .baseUrl("https://restaurant-api.dicoding.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}
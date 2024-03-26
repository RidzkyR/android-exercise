package com.example.android_pratice_recyleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(private val listName: List<String>) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false) // ambil layout adapter
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.isiData.text = listName[position] // replace tv_item_main menjadi data yang ingin ditampilkan nanti, dan untuk listNam[indeksnya] jadi looping
    }

    override fun getItemCount(): Int = listName.size


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)  {
        val isiData = view.findViewById<TextView>(R.id.tv_item_main) // CLass ini digunakan untuk inisalisasi id komponen View
    }
}
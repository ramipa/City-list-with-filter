package com.example.citylistwithfilters

import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class CitiesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tv: TextView = itemView.findViewById(android.R.id.text1) as TextView

    init {
        tv.setOnClickListener {
            Toast.makeText(tv.context, tv.text, Toast.LENGTH_SHORT).show()
        }

    }
}
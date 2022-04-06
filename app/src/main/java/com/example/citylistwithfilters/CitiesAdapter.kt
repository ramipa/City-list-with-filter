package com.example.citylistwithfilters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CitiesAdapter() : RecyclerView.Adapter<CitiesViewHolder>() {

    var cities: List<String> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CitiesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val row: View = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        return CitiesViewHolder(row)
    }

    override fun onBindViewHolder(holder: CitiesViewHolder, position: Int) {
        val city = cities[position]
        holder.tv.text = city
    }

    override fun getItemCount(): Int = cities.size

}
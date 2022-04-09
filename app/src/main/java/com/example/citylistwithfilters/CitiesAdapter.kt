package com.example.citylistwithfilters

import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.view.LayoutInflater
import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView

class CitiesAdapter(cityNames: MutableList<String>) : RecyclerView.Adapter<CitiesViewHolder>(),
    Filterable {

    private var cities: MutableList<String> = cityNames
    var citiesFull: MutableList<String> = cityNames


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


    override fun getFilter(): Filter {
        return exampleFilter;
    }

    private val exampleFilter: Filter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList: MutableList<String>

            val charSearch = constraint.toString()
            if (charSearch.isEmpty()) {
                filteredList = citiesFull
            } else {
                val resultList = ArrayList<String>()

                for (row in citiesFull) {
                    var isFind = false

                    for (i in charSearch.indices) {
                        if (charSearch[i] == row[i].lowercaseChar()) {
                            isFind = true
                            continue
                        } else {
                            isFind = false
                            break
                        }
                    }

                    if (isFind) resultList.add(row)
                }

                filteredList = resultList
            }
            val filterResults = FilterResults()
            filterResults.values = filteredList
            return filterResults
        }

        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
            cities = p1?.values as MutableList<String>
            notifyDataSetChanged()
        }
    }
}
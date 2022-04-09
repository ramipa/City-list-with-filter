package com.example.citylistwithfilters

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.citylistwithfilters.databinding.ActivityMainBinding
import com.example.citylistwithfilters.model.Cities
import com.example.citylistwithfilters.model.City
import com.google.gson.Gson
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var gson: Gson
    private lateinit var binding: ActivityMainBinding

    private lateinit var citiesRaw: Array<City>

    private lateinit var adapter: CitiesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gson = Gson()

        val citiesStream = resources.openRawResource(R.raw.russian_cities)
        citiesRaw = gson.fromJson(InputStreamReader(citiesStream), Cities::class.java).cities

        val cityNames: MutableList<String> = mutableListOf()
        for (city in citiesRaw) {
            cityNames.add(city.name)
        }

        adapter = CitiesAdapter(cityNames)

        val layoutManager = LinearLayoutManager(this)
        binding.rView.layoutManager = layoutManager
        binding.rView.adapter = adapter

        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                adapter.filter.filter(binding.editTextTextPersonName.text);
            }

            override fun afterTextChanged(p0: Editable?) {}

        })
    }
}
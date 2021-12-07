package com.marianunez.pokedex.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.pokedex.data.DataSource
import com.marianunez.pokedex.databinding.ActivityMainBinding
import com.marianunez.pokedex.ui.adapter.PokedexAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }


    private fun initUI(){

        val myDataset = DataSource().getPokemon()

        recyclerView = binding.pokemonList
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = PokedexAdapter(myDataset)
    }


}
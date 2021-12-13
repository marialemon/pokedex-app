package com.marianunez.pokedex.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.marianunez.pokedex.databinding.ActivityMainBinding
import com.marianunez.pokedex.ui.adapter.PokedexAdapter
import com.marianunez.pokedex.ui.viewmodel.PokedexViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    //declare ViewModel
    private lateinit var viewModel: PokedexViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //inicializamos el ViewModel
        //con esto hacemos que el ViewModel pueda ser utilizado en todas las llamadas que necesitemos
        viewModel = ViewModelProvider(this)[PokedexViewModel::class.java]

        initUI()
    }


    private fun initUI(){
        binding.pokemonList.layoutManager = LinearLayoutManager(this)
        binding.pokemonList.adapter = PokedexAdapter()

        //solicitar lista
        viewModel.getPokemonList()

        //observar cambios en la lista
        viewModel.pokemonList.observe(this, Observer { list ->
            (binding.pokemonList.adapter as PokedexAdapter).setData(list)
        })
    }

}
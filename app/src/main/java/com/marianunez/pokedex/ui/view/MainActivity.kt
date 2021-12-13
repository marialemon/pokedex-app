package com.marianunez.pokedex.ui.view

import android.os.Bundle
import android.telecom.Call
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.marianunez.pokedex.data.Pokemon
import com.marianunez.pokedex.data.network.PokemonApi
import com.marianunez.pokedex.databinding.ActivityMainBinding
import com.marianunez.pokedex.ui.adapter.PokedexAdapter
import com.marianunez.pokedex.ui.viewmodel.PokedexViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        callApi()
    }


    private fun initUI(){

        binding.pokemonList.layoutManager = LinearLayoutManager(this)

    }


    private fun callApi(){

        CoroutineScope(Dispatchers.IO).launch {
            val call = PokemonApi.retrofitService
            val pokemons = call.getPokemon()

            pokemons.enqueue(object: Callback<Pokemon>{
                override fun onResponse(
                    call: retrofit2.Call<Pokemon>,
                    response: Response<Pokemon>
                ) {
                    val result = response.body()
                    println(result)
                }

                override fun onFailure(call: retrofit2.Call<Pokemon>, t: Throwable) {
                   println("falla")
                }
            })
        }
    }


}
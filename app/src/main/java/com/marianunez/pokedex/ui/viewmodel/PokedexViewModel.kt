package com.marianunez.pokedex.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marianunez.pokedex.data.ApiResponse
import com.marianunez.pokedex.data.PokemonResults
import com.marianunez.pokedex.data.network.PokemonApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class PokedexViewModel() : ViewModel() {

    //creamos un MutableLiveData porque así garantizamos que las actualizaciones sean constantes
    //luego necesitaremos un oberver en la ui
    val pokemonList = MutableLiveData<List<PokemonResults>>()

    fun getPokemonList() {

        CoroutineScope(Dispatchers.IO).launch {

            val call = PokemonApi.retrofitService.getPokemon(100, 200)
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                    // accedemos a results de nuestra data class ApiResponse
                    response.body()?.results.let { list ->
                        pokemonList.postValue(list)
                    }
                }

                override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                    //si falla cancelamos la llamada
                    call.cancel()
                    println("Api call fail")
                }
            })

        }

    }

}
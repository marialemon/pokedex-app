package com.marianunez.pokedex.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.marianunez.pokedex.data.network.response.ApiResponse
import com.marianunez.pokedex.data.network.response.PokemonResults
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

            val call = PokemonApi.retrofitService.getPokemon(100, 0)
            call.enqueue(object : Callback<ApiResponse> {
                override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {

                    // accedemos a results de nuestra data class ApiResponse
                    response.body()?.results.let { list ->

                        //recorremos la lista para sacar el id
                        list?.map {
                            it.name = it.name.capitalize()
                            it.id = it.url.removeSuffix("/").split("/").last()
                            }

                        pokemonList.postValue(list)
                        println(list)
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
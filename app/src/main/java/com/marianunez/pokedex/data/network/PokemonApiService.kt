package com.marianunez.pokedex.data.network

import com.marianunez.pokedex.data.network.response.ApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

// https://pokeapi.co/

interface PokemonApiService {
    //@GET("pokemon?limit=100&offset=200")
    @GET("pokemon")
    fun getPokemon(@Query("limit") limit: Int, @Query("offset") offset: Int): Call<ApiResponse>
}


object PokemonApi {
    val retrofitService: PokemonApiService by lazy {
        RetrofitBuilder().retrofit.create(PokemonApiService::class.java)
    }
}
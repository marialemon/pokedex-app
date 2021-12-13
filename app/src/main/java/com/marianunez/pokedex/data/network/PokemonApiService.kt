package com.marianunez.pokedex.data.network

import com.marianunez.pokedex.data.Pokemon
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET



interface PokemonApiService {
    @GET("pokemon?limit=100&offset=200")

    fun getPokemon(): Call<Pokemon>
}


object PokemonApi {
    val retrofitService : PokemonApiService by lazy {
        RetrofitBuilder().retrofit.create(PokemonApiService::class.java)
    }
}
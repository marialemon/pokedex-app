package com.marianunez.pokedex.data.network.response

// https://pokeapi.co/

data class ApiResponse(
    var count: Int,
    var next: String,
    var previous: String,
    var results: List<PokemonResults>
)

data class PokemonResults(
    var name: String,
    var url: String,
    var id: String
)

data class PokemonDetail(
    val name: String,
    val id: Int,
    val weight: String
)
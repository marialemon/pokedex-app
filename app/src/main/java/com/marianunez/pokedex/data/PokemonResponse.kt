package com.marianunez.pokedex.data

// https://pokeapi.co/

data class ApiResponse (
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


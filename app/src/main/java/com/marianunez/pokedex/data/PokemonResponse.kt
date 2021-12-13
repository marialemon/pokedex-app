package com.marianunez.pokedex.data


data class ApiResponse (
    var count: Int,
    var next: String,
    var previous: String,
    var results: List<PokemonResults>
)

data class PokemonResults(
    var name: String,
    var url: String
)


package com.marianunez.pokedex.domain.model.mapper

import com.marianunez.pokedex.data.network.response.PokemonResults
import com.marianunez.pokedex.domain.model.PokemonModel

fun PokemonResults.toModel(): PokemonModel {
    return PokemonModel(id, name, url)
}
package com.marianunez.pokedex.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.pokedex.commons.loadImageByUrl
import com.marianunez.pokedex.data.network.response.PokemonResults
import com.marianunez.pokedex.databinding.ListPokemonBinding

class PokedexViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ListPokemonBinding.bind(view)

    private val imgRetro = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"
    private val img3D = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/home/"
    private val img = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/"

    fun bind(item: PokemonResults){
        binding.apply {
            itemTitle.text = item.name
            itemId.text = "#${item.id}"
            itemImage.loadImageByUrl("${img}${item.id}.png")
        }

    }
}
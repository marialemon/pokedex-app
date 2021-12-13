package com.marianunez.pokedex.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.pokedex.commons.loadImageByUrl
import com.marianunez.pokedex.data.PokemonResults
import com.marianunez.pokedex.databinding.ListPokemonBinding

class PokedexViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ListPokemonBinding.bind(view)

    fun bind(item: PokemonResults){

        binding.apply {
            itemTitle.text = item.name
            itemId.text = item.url
            itemImage.loadImageByUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png")
        }

    }
}
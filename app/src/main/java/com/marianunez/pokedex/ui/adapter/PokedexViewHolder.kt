package com.marianunez.pokedex.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.pokedex.commons.loadImageByUrl
import com.marianunez.pokedex.data.PokemonResults
import com.marianunez.pokedex.databinding.ListPokemonBinding
import com.marianunez.pokedex.ui.viewmodel.PokedexViewModel

class PokedexViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ListPokemonBinding.bind(view)

    private val img = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"

    fun bind(item: PokemonResults){
        binding.apply {
            itemTitle.text = item.name
            itemId.text = "#${item.id}"
            itemImage.loadImageByUrl("${img}${item.id}.png")
        }

    }
}
package com.marianunez.pokedex.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.pokedex.commons.loadImageByUrl
import com.marianunez.pokedex.databinding.ListPokemonBinding
import com.marianunez.pokedex.ui.model.Pokemon

class PokedexViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ListPokemonBinding.bind(view)

    fun bind(item: Pokemon){

        binding.apply {
            itemTitle.text = item.name
            itemId.text = item.id.toString()
            itemImage.loadImageByUrl("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/132.png")
        }

    }
}
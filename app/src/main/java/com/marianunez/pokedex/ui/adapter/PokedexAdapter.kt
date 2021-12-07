package com.marianunez.pokedex.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marianunez.pokedex.R
import com.marianunez.pokedex.ui.model.Pokemon

class PokedexAdapter(val pokemon:List<Pokemon>) : RecyclerView.Adapter<PokedexViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokedexViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_pokemon, parent, false)
        return PokedexViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: PokedexViewHolder, position: Int) {
        holder.bind(pokemon[position])
    }

    override fun getItemCount(): Int = pokemon.size


}
package com.marianunez.pokedex.commons

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImageByUrl(url: String) {

    //Implementamos Glide
    Glide.with(context)
        .load(url)
        .centerCrop()
        .into(this)

}
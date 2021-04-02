package com.example.esiea3atd1.presentation.api

import com.example.esiea3atd1.presentation.list.Genres

data class GenreDetailResponse (
    val name: String,
    val types: List<PokemonSlot>
)

data class PokemonSlot(
    val slot: Int,
    val type: PokemonType
)

data class PokemonType(
    val name: String,
    val url: String
)
package com.example.esiea3atd1.presentation.api

import retrofit2.Call
import retrofit2.http.GET


interface PokeApi {
    @GET("pokemon") //TODO : changer avec les bonnes valeurs
    fun getPokemonList(): Call<MusicLyricsResponse>
}
package com.example.esiea3atd1.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface PokeApi {
    @GET("pokemon") //TODO : changer avec les bonnes valeurs
    fun getPokemonList(): Call<GenreListResponse>

    @GET("pokemon/{id}") //TODO : changer avec les bonnes valeurs
    fun getPokemonDetails(@Path ("id") id: Int): Call<GenreDetailResponse>
}
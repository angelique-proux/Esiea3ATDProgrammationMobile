package com.example.esiea3atd1.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    @GET("region/{region}?fields=name;flag")
    fun getCountriesPerRegion(@Path("region") region: String): Call<List<CountryResponse>>

    @GET("name/{name}?fields=name;capital;region;population;area;borders;currencies;languages;flag")
    fun getSpecificCountry(@Path("name") name: String): Call<List<CountryResponse>>

    @GET("lang/{language}?fields=name;capital;region;population;area;borders;currencies;languages;flag")
    fun getCountriesPerLanguage(@Path("language") language: String): Call<List<CountryResponse>>
}
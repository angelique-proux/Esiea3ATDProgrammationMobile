package com.example.esiea3atd1.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CountriesApi {

    @GET("region/{region}?fields=name")
    fun getCountriesPerRegion(@Path("region") region: String): Call<List<CountryResponse>>

    @GET("name/{name}?fields=name;capital;region;subregion;population;area;borders;currencies;languages;flag")
    fun getSpecificCountry(@Path("name") name: String): Call<List<CountryResponse>>

}
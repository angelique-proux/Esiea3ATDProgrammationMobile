package com.example.esiea3atd1.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UniversityApi {
    @GET("search?country={country}")
    fun getUniversitiesPerCountry(@Path("country") country: String): Call<List<UniversityResponse>>
}
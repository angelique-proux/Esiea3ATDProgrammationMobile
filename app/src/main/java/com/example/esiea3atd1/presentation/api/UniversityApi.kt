package com.example.esiea3atd1.presentation.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UniversityApi {
    @GET("/search")
    fun getUniversitiesPerCountry(@Query("country") country: String): Call<List<UniversityResponse>>
}
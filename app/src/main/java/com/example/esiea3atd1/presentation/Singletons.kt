package com.example.esiea3atd1.presentation

import com.example.esiea3atd1.presentation.CountryApplication.Companion.context
import com.example.esiea3atd1.presentation.api.CountriesApi
import com.example.esiea3atd1.presentation.api.UniversityApi
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

class Singletons {
    companion object {
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024 * 1024)

        val okhttpClient: OkHttpClient = OkHttpClient().newBuilder()
            .cache(cache)
            .build()


        val countriesApi: CountriesApi = Retrofit.Builder()
                .baseUrl("https://restcountries.eu/rest/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(CountriesApi::class.java)

        val universityApi: UniversityApi = Retrofit.Builder()
                .baseUrl("http://universities.hipolabs.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient)
                .build()
                .create(UniversityApi::class.java)


    }
}
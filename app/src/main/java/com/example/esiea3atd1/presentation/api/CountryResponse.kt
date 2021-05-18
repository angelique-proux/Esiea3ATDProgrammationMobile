package com.example.esiea3atd1.presentation.api

data class CountryResponse (
        val name: String,
        val nativeName: String,
        val capital: String,
        val region: String,
        val population: Int,
        val area: Float,
        val borders: List<String>,
        val currencies: List<Currencies>,
        val languages: List<Languages>,
        val flag: String
)

data class Languages (
        val nativeName: String
)

data class Currencies (
        val name: String,
        val symbol: String
)
package com.example.esiea3atd1.presentation.list


class RegionList {
    private var regionList: List<Region>? = null

    private fun setRegionList() {
        regionList = arrayListOf<Region>().apply {
        add(Region("Afrique", "Afrika","Africa"))
        add(Region("Amériques", "Amerikas","Americas"))
        add(Region("Asie", "Asien","Asia"))
        add(Region("Europe", "Europa","Europe"))
        add(Region("Océanie", "Ozeanien","Oceania"))
        add(Region("Pôle", "Pol","Polar"))
        }
    }

    fun getRegionList(): List<Region>? {
        setRegionList()
        return this.regionList
    }
}

data class Region(
        val frName : String,
        val deName : String,
        val enName : String
)
package com.example.esiea3atd1.presentation.list.continent


class RegionList {
    private var regionList: List<String>? = null

    private fun setRegionList() {
        regionList = arrayListOf<String>().apply {
        add("Africa")
        add("Americas")
        add("Asia")
        add("Europe")
        add("Oceania")
        add("Polar")
        }
    }

    fun getRegionList(): List<String>? {
        setRegionList()
        return this.regionList
    }
}
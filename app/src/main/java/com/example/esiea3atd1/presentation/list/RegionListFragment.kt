package com.example.esiea3atd1.presentation.list

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3atd1.R

class RegionListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView

    private val adapter = RegionAdapter(listOf(), ::onClikedRegion)

    private val sharedPref: SharedPreferences? = activity?.getSharedPreferences("app", Context.MODE_PRIVATE)

    private val layoutManager = LinearLayoutManager(context)

    private val regionListAllLanguages = RegionList()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_region_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Recycle view
        recyclerView = view.findViewById(R.id.region_recyclerview)
        recyclerView.apply {
            layoutManager= this@RegionListFragment.layoutManager
            adapter = this@RegionListFragment.adapter
        }

        //Get all regions to show them
        val regionList : List<Region> = regionListAllLanguages.getRegionList()!!

        adapter.updateList(regionList)

    }

    private fun onClikedRegion(region: String) {
        findNavController().navigate(R.id.NavigateToCountriesList, bundleOf(
                "regionName" to region
        ))
    }
}
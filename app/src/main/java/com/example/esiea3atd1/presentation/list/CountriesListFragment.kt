package com.example.esiea3atd1.presentation.list

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3atd1.R
import com.example.esiea3atd1.presentation.Singletons
import com.example.esiea3atd1.presentation.api.CountryResponse
import com.tapadoo.alerter.Alerter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CountriesListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = CountryAdapter(listOf(), ::onClickedCountry)

    private val sharedPref: SharedPreferences? = activity?.getSharedPreferences("app", Context.MODE_PRIVATE)

    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Recycle view
        recyclerView = view.findViewById(R.id.country_recyclerview)
        recyclerView.apply {
            layoutManager= this@CountriesListFragment.layoutManager
            adapter = this@CountriesListFragment.adapter
        }

        val list = getListFromCache()
        if(list.isEmpty()){
            callApi()
        } else {
            showList(list)
        }

    }

    private fun getListFromCache(): List<CountryResponse> {
        //sharedPref
        //TODO
        return emptyList()
    }

    private fun saveListIntoCache() {
        //TODO
    }

    private fun callApi() {
        val region: String = arguments?.getString("regionName").toString()
        val language: String = arguments?.getString("languageName").toString()
        if (region != "-1") {
            Singletons.countriesApi.getCountriesPerRegion(region).enqueue(object: Callback<List<CountryResponse>> {
                override fun onFailure(call: Call<List<CountryResponse>>, t: Throwable) {
                    Alerter.Companion.create(activity!!)
                        .setTitle(R.string.Notification)
                        .setText(R.string.enableWifi)
                        .setIcon(R.drawable.ic_baseline_flight_24)
                        .setBackgroundColorRes(R.color.notifications)
                        .setDuration(3000)
                        .setOnClickListener {
                            Toast.makeText(context, R.string.enableWifi, Toast.LENGTH_SHORT).show()
                        }
                        .show()
                }
                override fun onResponse(
                    call: Call<List<CountryResponse>>,
                    response: Response<List<CountryResponse>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val countriesResponse: List<CountryResponse> = response.body()!!
                        saveListIntoCache()
                        showList(countriesResponse)
                    }
                }
            })
        } else {
            Singletons.countriesApi.getCountriesPerLanguage(language).enqueue(object: Callback<List<CountryResponse>> {
                override fun onFailure(call: Call<List<CountryResponse>>, t: Throwable) {
                    //TODO("Not yet implemented")
                }
                override fun onResponse(
                    call: Call<List<CountryResponse>>,
                    response: Response<List<CountryResponse>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val countriesResponse: List<CountryResponse> = response.body()!!
                        saveListIntoCache()
                        showList(countriesResponse)
                    }
                }
            })
        }
    }


    private fun showList(countriesList: List<CountryResponse>) {
        adapter.updateList(countriesList, context)
    }

    private fun onClickedCountry(name: String) {
        findNavController().navigate(R.id.NavigateToCountryDetail, bundleOf(
            "countryName" to name
        ))
    }
}
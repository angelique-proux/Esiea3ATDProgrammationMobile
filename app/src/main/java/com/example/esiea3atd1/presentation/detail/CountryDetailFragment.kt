package com.example.esiea3atd1.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.esiea3atd1.R
import com.example.esiea3atd1.presentation.Singletons
import com.example.esiea3atd1.presentation.api.CountryResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CountryDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    private lateinit var textViewCapital: TextView

    private lateinit var textViewPopulation: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.NavigateToRegionList)
        }

        textViewName = view.findViewById(R.id.country_detail_name)
        textViewCapital = view.findViewById(R.id.country_detail_capital_text)
        textViewPopulation = view.findViewById(R.id.country_detail_population_text)
        callApi()
    }

    private fun callApi() {
        val countryName: String = arguments?.getString("countryName")!!
        Singletons.countriesApi.getSpecificCountry(countryName).enqueue(object: Callback<List<CountryResponse>> {
            override fun onFailure(call: Call<List<CountryResponse>>, t: Throwable) {
                //TODO("Not yet implemented")
            }
            override fun onResponse(
                    call: Call<List<CountryResponse>>,
                    response: Response<List<CountryResponse>>
            ) {
                if(response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!!.get(0).name
                    textViewCapital.text = response.body()!!.get(0).capital
                    textViewPopulation.text = response.body()!!.get(0).population.toString()
                }
            }
        })
    }

}
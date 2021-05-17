package com.example.esiea3atd1.presentation.detail

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.esiea3atd1.R
import com.example.esiea3atd1.presentation.Singletons
import com.example.esiea3atd1.presentation.api.CountryResponse
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou
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

    private lateinit var textViewArea: TextView

    private lateinit var textViewContinent: TextView

    private lateinit var textViewBorders: TextView

    private lateinit var imageViewFlag: ImageView

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
            findNavController().navigate(R.id.NavigateToMenu)
        }
        view.findViewById<Button>(R.id.universities_button).setOnClickListener{
            val bundle = bundleOf("countryNameForUni" to textViewName.text.toString())
            view.findNavController().navigate(R.id.NavigateToUniversitiesList, bundle)
        }


        textViewName = view.findViewById(R.id.country_detail_name)
        textViewCapital = view.findViewById(R.id.country_detail_capital_text)
        textViewPopulation = view.findViewById(R.id.country_detail_population_text)
        textViewArea = view.findViewById(R.id.country_detail_area_text)
        textViewContinent = view.findViewById(R.id.country_detail_continent_text)
        textViewBorders = view.findViewById(R.id.country_detail_borders_text)
        imageViewFlag = view.findViewById(R.id.country_detail_flag)


        callApi()
    }

    private fun callApi() {
        val countryName: String = arguments?.getString("countryName")!!
        Singletons.countriesApi.getSpecificCountry(countryName).enqueue(object: Callback<List<CountryResponse>> {
            @SuppressLint("WrongConstant")
            override fun onFailure(call: Call<List<CountryResponse>>, t: Throwable) {
                Toast.makeText(context, resources.getString(R.string.enableWifi), 300)
            }
            override fun onResponse(
                    call: Call<List<CountryResponse>>,
                    response: Response<List<CountryResponse>>
            ) {
                if(response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!![0].name
                    textViewCapital.text = response.body()!![0].capital
                    textViewPopulation.text = response.body()!![0].population.toString()
                    textViewArea.text = response.body()!![0].area.toString()
                    textViewContinent.text = response.body()!![0].region

                    if (response.body()!![0].borders.isNotEmpty()) {
                        var bordersCountries = ""
                        for (i in response.body()!![0].borders.indices) {
                            bordersCountries += response.body()!![0].borders[i] + " ; "
                            if(i%4==3) {
                                bordersCountries += "\n"
                            }
                        }
                        textViewBorders.text = bordersCountries
                    } else {
                        textViewBorders.text = resources.getString(R.string.NoBorders)
                    }

                    if (response.body()!![0].name.isEmpty()) {
                        textViewName.text = resources.getString(R.string.NoCapital)
                    }

                    GlideToVectorYou.init().with(context).load(Uri.parse(response.body()!![0].flag),imageViewFlag)
                }
            }
        })
    }
}
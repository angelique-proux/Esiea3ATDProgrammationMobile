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
import com.tapadoo.alerter.Alerter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class CountryDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    private lateinit var textViewCapital: TextView

    private lateinit var textViewLanguages: TextView

    private lateinit var textViewPopulation: TextView

    private lateinit var textViewArea: TextView

    private lateinit var textViewContinent: TextView

    private lateinit var textViewCurrencies: TextView

    private lateinit var textViewBorders: TextView

    private lateinit var imageViewFlag: ImageView

    private var countryNameString: String = ""

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.menu_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToMenu)
        }
        view.findViewById<Button>(R.id.universities_button).setOnClickListener{
            //Allow the navigation only in the case of a country is found
            if (countryNameString != "") {
                //Fix errors related to different country's names in the APIs.
                when (countryNameString) {
                    "American Samoa" -> {
                        countryNameString = "Samoa"
                    }
                    "Korea (Democratic People's Republic of)" -> {
                        countryNameString = "Korea, Democratic People's Republic of"
                    }
                    "Korea (Republic of)" -> {
                        countryNameString = "Korea, Republic of"
                    }
                    "Bolivia (Plurinational State of)" -> {
                        countryNameString = "Bolivia, Plurinational State of"
                    }
                    "Congo (Democratic Republic of the)" -> {
                        countryNameString = "Congo, the Democratic Republic of the"
                    }
                    "Iran (Islamic Republic of)" -> {
                        countryNameString = "Iran"
                    }
                    "Venezuela (Bolivarian Republic of)" -> {
                        countryNameString = "Venezuela, Bolivarian Republic of"
                    }
                    "United States of America" -> {
                        countryNameString = "United States"
                    }
                }

                val bundle = bundleOf("countryNameForUni" to countryNameString)
                view.findNavController().navigate(R.id.NavigateToUniversitiesList, bundle)
            }
        }


        textViewName = view.findViewById(R.id.country_detail_name)
        textViewCapital = view.findViewById(R.id.country_detail_capital_text)
        textViewLanguages = view.findViewById(R.id.country_detail_languages_text)
        textViewPopulation = view.findViewById(R.id.country_detail_population_text)
        textViewArea = view.findViewById(R.id.country_detail_area_text)
        textViewContinent = view.findViewById(R.id.country_detail_continent_text)
        textViewCurrencies = view.findViewById(R.id.country_detail_currencies_text)
        textViewBorders = view.findViewById(R.id.country_detail_borders_text)
        imageViewFlag = view.findViewById(R.id.country_detail_flag)


        callApi()
    }

    private fun callApi() {
        val countryName: String = arguments?.getString("countryName")!!
        Singletons.countriesApi.getSpecificCountry(countryName).enqueue(object: Callback<List<CountryResponse>> {
            override fun onFailure(call: Call<List<CountryResponse>>, t: Throwable) {
                Alerter.Companion.create(activity!!)
                    .setTitle(R.string.pop_messages)
                    .setText(R.string.enableWifi)
                    .setIcon(R.drawable.ic_baseline_flight_24)
                    .setBackgroundColorRes(R.color.alertes)
                    .setDuration(3500)
                    .setOnClickListener {
                        Toast.makeText(context, R.string.enableWifi, Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.NavigateToMenu)
                    }
                    .show()
            }
            @SuppressLint("SetTextI18n")
            override fun onResponse(
                    call: Call<List<CountryResponse>>,
                    response: Response<List<CountryResponse>>
            ) {
                if(response.isSuccessful && response.body() != null){
                    var number = 0
                    if (response.body()!![0].name != countryName) {
                        number = 1
                    }
                    countryNameString = response.body()!![number].name
                    textViewName.text = response.body()!![number].nativeName
                    textViewCapital.text = response.body()!![number].capital
                    textViewPopulation.text = response.body()!![number].population.toString()
                    textViewArea.text = response.body()!![number].area.toString()
                    textViewContinent.text = response.body()!![number].region
                    textViewCurrencies.text = response.body()!![number].currencies[0].name + " " + response.body()!![number].currencies[0].symbol

                    if (response.body()!![number].borders.isNotEmpty()) {
                        var bordersCountries = ""
                        for (i in response.body()!![number].borders.indices) {
                            bordersCountries += response.body()!![number].borders[i] + " "
                            if(i%4==3) {
                                bordersCountries += "\n"
                            }
                        }
                        textViewBorders.text = bordersCountries
                    } else {
                        textViewBorders.text = resources.getString(R.string.NoBorders)
                    }

                    if (response.body()!![number].languages.isNotEmpty()) {
                        var languagesNames = ""
                        for (i in response.body()!![number].languages.indices) {
                            languagesNames += response.body()!![number].languages[i].nativeName + " "
                            if(i%2==1 && i != response.body()!![number].languages.size-1) {
                                languagesNames += "\n"
                            }
                        }
                        textViewLanguages.text = languagesNames
                    } else {
                        textViewLanguages.text = resources.getString(R.string.NoLanguages)
                    }

                    if (response.body()!![number].capital.isEmpty()) {
                        textViewCapital.text = resources.getString(R.string.NoCapital)
                    }

                    GlideToVectorYou.init().with(context).load(Uri.parse(response.body()!![number].flag),imageViewFlag)
                }
            }
        })
    }
}
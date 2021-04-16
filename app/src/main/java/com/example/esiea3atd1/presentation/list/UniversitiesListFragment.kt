package com.example.esiea3atd1.presentation.list

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3atd1.R
import com.example.esiea3atd1.presentation.Singletons
import com.example.esiea3atd1.presentation.api.UniversityResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UniversitiesListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    private val adapter = UniversityAdapter(listOf())

    private val sharedPref: SharedPreferences? = activity?.getSharedPreferences("app", Context.MODE_PRIVATE)

    private val layoutManager = LinearLayoutManager(context)

    private lateinit var textViewCountry: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_university_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Recycle view
        recyclerView = view.findViewById(R.id.university_recyclerview)
        recyclerView.apply {
            layoutManager= this@UniversitiesListFragment.layoutManager
            adapter = this@UniversitiesListFragment.adapter
        }

        textViewCountry = view.findViewById(R.id.country_name)
        textViewCountry.text = "Coucou" /*+ arguments?.getString("countryNameForUni")*/

        /*val list = getListFromCache()
        if(list.isEmpty()){
            callApi()
        } else {
            showList(list)
        }*/

    }

    private fun getListFromCache(): List<UniversityResponse> {
        //sharedPref
        //TODO
        return emptyList()
    }

    private fun saveListIntoCache() {
        //TODO
    }

    private fun callApi() {
        val country: String = arguments?.getString("countryNameForUni")!!
        Singletons.universityApi.getUniversitiesPerCountry(country).enqueue(object: Callback<List<UniversityResponse>> {
            override fun onFailure(call: Call<List<UniversityResponse>>, t: Throwable) {
                //TODO("Not yet implemented")
            }
            override fun onResponse(
                    call: Call<List<UniversityResponse>>,
                    response: Response<List<UniversityResponse>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val universitiesResponse: List<UniversityResponse> = response.body()!!
                    textViewCountry.text = response.body()!!.get(0).country
                    saveListIntoCache()
                    showList(universitiesResponse)
                }
            }
        })
    }


    private fun showList(universitiesList: List<UniversityResponse>) {
        adapter.updateList(universitiesList)
    }
}
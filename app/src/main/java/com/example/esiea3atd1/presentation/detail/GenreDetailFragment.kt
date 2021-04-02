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
import com.example.esiea3atd1.presentation.api.GenreDetailResponse
import com.example.esiea3atd1.presentation.api.GenreListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class GenreDetailFragment : Fragment() {

    private lateinit var textViewName: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_genre_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.NavigateToGenresList)
        }

        textViewName = view.findViewById(R.id.genre_detail_name)
        callApi()
    }

    private fun callApi() {
        Singletons.pokeApi.getPokemonDetails( "1").enqueue(object: Callback<GenreDetailResponse> {
            override fun onFailure(call: Call<GenreDetailResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }
            override fun onResponse(
                call: Call<GenreDetailResponse>,
                response: Response<GenreDetailResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                    textViewName.text = response.body()!!.name
                }
            }
        })
    }

}
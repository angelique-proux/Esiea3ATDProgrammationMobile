package com.example.esiea3atd1.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3atd1.R
import com.example.esiea3atd1.presentation.Singletons
import com.example.esiea3atd1.presentation.api.PokeApi
import com.example.esiea3atd1.presentation.api.GenreListResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MusicListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = MusicAdapter(listOf(), ::onClikedGenre)


    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Recycle view
        recyclerView = view.findViewById(R.id.music_recyclerview)
        recyclerView.apply {
            layoutManager= this@MusicListFragment.layoutManager
            adapter = this@MusicListFragment.adapter
        }

        Singletons.pokeApi.getPokemonList().enqueue(object: Callback<GenreListResponse> {
            override fun onFailure(call: Call<GenreListResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<GenreListResponse>,
                response: Response<GenreListResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                    val musicResponse: GenreListResponse = response.body()!!
                    adapter.updateList(musicResponse.results)
                }
            }
        })

        /*val musicList = arrayListOf<Genres>().apply {
            add(Genres("Pop"))
            add(Genres("Rock"))
            add(Genres("Classique"))
            add(Genres("Métal"))
            add(Genres("Rap"))
        }

        adapter.updateList(musicList)*/

    }

    private fun onClikedGenre(genres: Genres) {
        findNavController().navigate(R.id.NavigateToDetailGenre)
    }
}
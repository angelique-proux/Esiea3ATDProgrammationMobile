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
import com.example.esiea3atd1.presentation.api.PokeApi
import com.example.esiea3atd1.presentation.api.MusicLyricsResponse
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

        //manipuler l'interface MusicApi
        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val pokeApi: PokeApi = retrofit.create(PokeApi::class.java)

        //créer la liste
        pokeApi.getPokemonList().enqueue(object: Callback<MusicLyricsResponse> {
            override fun onFailure(call: Call<MusicLyricsResponse>, t: Throwable) {
                //TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<MusicLyricsResponse>,
                response: Response<MusicLyricsResponse>
            ) {
                if(response.isSuccessful && response.body() != null){
                    val musicResponse: MusicLyricsResponse = response.body()!!
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
package com.example.esiea3atd1.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3atd1.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MusicListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = MusicAdapter(listOf())
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

        recyclerView = view.findViewById(R.id.music_recyclerview)
        recyclerView.apply {
            layoutManager= this@MusicListFragment.layoutManager
            adapter = this@MusicListFragment.adapter
        }

        val musicList = arrayListOf<Genres>().apply {
            add(Genres("Pop"))
            add(Genres("Rock"))
            add(Genres("Classique"))
            add(Genres("Métal"))
            add(Genres("Rap"))
        }

        adapter.updateList(musicList)

    }
}
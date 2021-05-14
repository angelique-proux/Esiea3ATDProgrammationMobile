package com.example.esiea3atd1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MenuFragment : Fragment() {

    private lateinit var textMenu: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        view.findViewById<Button>(R.id.region_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToRegionList0)
        }

        view.findViewById<Button>(R.id.countries_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToMyRegion, bundleOf(
                "regionName" to "Europe" //@TODO remplacer "Europe" par la région sélectionnée
            ))
        }

        view.findViewById<Button>(R.id.country_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToMyCountry, bundleOf(
                "countryName" to "France" //@TODO remplacer "France" par le pays sélectionné
            ))
        }

    }

}
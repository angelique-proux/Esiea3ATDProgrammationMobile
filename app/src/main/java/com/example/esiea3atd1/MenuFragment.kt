package com.example.esiea3atd1

import android.annotation.SuppressLint
import android.content.SharedPreferences
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

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class MenuFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences
    //keys from settings xml
    private var prefUserName: String = "username"
    private var prefRegion : String = "region"
    private var prefCountry : String = "country"
    private var prefLanguage : String = "my_language"
    //textView variables
    private lateinit var textWelcome: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PreferenceManager.setDefaultValues(context, R.xml.root_preferences, false)
        textWelcome = requireView().findViewById(R.id.menu_text)
        readSettings()

        view.findViewById<Button>(R.id.region_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToRegionList0)
        }

        view.findViewById<Button>(R.id.countries_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToMyRegion, bundleOf(
                "regionName" to sharedPreferences.getString(prefRegion, "Europe")
            ))
        }

        view.findViewById<Button>(R.id.country_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToMyCountry, bundleOf(
                "countryName" to sharedPreferences.getString(prefCountry, "France")
            ))
        }

        view.findViewById<Button>(R.id.language_button).setOnClickListener {
            findNavController().navigate(R.id.NavigateToMyRegion, bundleOf(
                "languageName" to sharedPreferences.getString(prefLanguage, "fr")
            ))
        }

    }

    //Read Settings from SettingsActivity
    @SuppressLint("SetTextI18n")
    private fun readSettings() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        textWelcome.text = resources.getString(R.string.welcome) + " " + sharedPreferences.getString(prefUserName, "")
    }

}
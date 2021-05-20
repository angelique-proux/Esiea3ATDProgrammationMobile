package com.example.esiea3atd1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager

class InformationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        PreferenceManager.setDefaultValues(context, R.xml.root_preferences, false)

        view.findViewById<ImageButton>(R.id.imageButtonApp).setOnClickListener {
            findNavController().navigate(R.id.NavigateToMenu0)
        }
        view.findViewById<TextView>(R.id.githubLinkApp).setOnClickListener {
            openBrowser("http://github.com")
        }
        view.findViewById<TextView>(R.id.apiLinkApp).setOnClickListener {
            openBrowser("https://restcountries.eu/")
        }

    }

    //Open internet browser
    private fun openBrowser(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }

}
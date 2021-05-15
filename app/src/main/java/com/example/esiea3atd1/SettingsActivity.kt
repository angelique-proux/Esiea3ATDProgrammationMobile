package com.example.esiea3atd1

import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.example.esiea3atd1.settings.LanguageManager
import java.util.*

class SettingsActivity : AppCompatActivity(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var langManager: LanguageManager

    override fun onCreate(savedInstanceState: Bundle?) {
        langManager = LanguageManager(this)
        PreferenceManager.getDefaultSharedPreferences(baseContext)
            .registerOnSharedPreferenceChangeListener(this)

        setThemeOfApp()
        setLanguageOfApp()

        super.onCreate(savedInstanceState)

        setContentView(R.layout.settings_activity)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //Show preferences
    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)
        }
    }

    //Go back to the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    //Change theme
    private fun setThemeOfApp() {
        val sharedpreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        if(sharedpreferences.getString("theme_choice", "BRIGHT").equals("BRIGHT")) {
            setTheme(R.style.BrightTheme)
        } else {
            setTheme(R.style.DarkTheme)
        }
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String?) {
        if(key.equals("theme_choice")) {
            this.recreate()
        } else if (key.equals("app_language")) {
            this.recreate()
        }
    }

    //Change language
    private fun setLanguageOfApp() {
        val sharedpreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        if(sharedpreferences.getString("app_language", "fr").equals("fr")) {
            langManager.updateLanguageRessources("fr")
        } else if(sharedpreferences.getString("app_language", "fr").equals("de")){
            langManager.updateLanguageRessources("de")
        } else {
            langManager.updateLanguageRessources("en")
        }
    }
}
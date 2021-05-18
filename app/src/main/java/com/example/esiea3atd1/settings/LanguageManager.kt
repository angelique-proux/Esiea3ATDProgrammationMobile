package com.example.esiea3atd1.settings

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

@Suppress("DEPRECATION")
class LanguageManager(context: Context) {

    private var languageContext: Context = context
    private var sharedPreferences: SharedPreferences =
        this.languageContext.getSharedPreferences("LANG", Context.MODE_PRIVATE)

    fun updateLanguageResources(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val resources: Resources = languageContext.resources

        val config: Configuration = resources.configuration
        config.setLocale(locale)

        resources.updateConfiguration(config, resources.displayMetrics)
        setLanguage(language)
    }

    private fun setLanguage(code: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("lang", code)
        editor.apply()
    }

}
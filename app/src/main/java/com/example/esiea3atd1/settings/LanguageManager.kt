package com.example.esiea3atd1.settings

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

@Suppress("DEPRECATION")
class LanguageManager {

    private var languageContext: Context
    private var sharedPreferences: SharedPreferences

    constructor(context: Context) {
        languageContext = context
        sharedPreferences = this.languageContext.getSharedPreferences("LANG", Context.MODE_PRIVATE)
    }

    fun updateLanguageResources(language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)

        val resources: Resources = languageContext.resources

        val config: Configuration = resources.configuration
        config.setLocale(locale)

        resources.updateConfiguration(config, resources.displayMetrics)
        setLanguage(language)
    }

    fun setLanguage(code: String) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("lang", code)
        editor.commit()
    }

    fun getLanguage(): String? {
        return sharedPreferences.getString("lang", "en")
    }

}
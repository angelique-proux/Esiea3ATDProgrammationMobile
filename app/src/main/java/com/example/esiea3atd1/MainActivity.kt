package com.example.esiea3atd1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.example.esiea3atd1.settings.LanguageManager
import com.example.esiea3atd1.settings.SettingsActivity
import com.tapadoo.alerter.Alerter


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private var settingsCode = 243
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var langManager: LanguageManager

    override fun onCreate(savedInstanceState: Bundle?) {
        langManager = LanguageManager(this)

        super.onCreate(savedInstanceState)
        setLanguageOfApp()
        setThemeOfApp()
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivityForResult(intent, settingsCode)
                true
            }
            R.id.action_alertes -> {
                Alerter.Companion.create(this)
                    .setTitle(R.string.pop_messages)
                    .setText(R.string.tryPopMessages)
                    .setIcon(R.drawable.ic_baseline_flight_24)
                    .setBackgroundColorRes(R.color.alertes)
                    .setDuration(5000)
                    .setOnClickListener {
                        Toast.makeText(this, R.string.tryNotification, Toast.LENGTH_SHORT).show()
                    }
                    .show()
                true
            }
            R.id.action_notifications -> {
                Alerter.Companion.create(this)
                    .setTitle(R.string.pop_messages)
                    .setText(R.string.tryNotification)
                    .setIcon(R.drawable.ic_baseline_flight_24)
                    .setBackgroundColorRes(R.color.alertes)
                    .setDuration(3500)
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Change theme
    private fun setThemeOfApp() {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        if(sharedPreferences.getString("theme_choice", "BRIGHT").equals("BRIGHT")) {
            setTheme(R.style.BrightTheme)
        } else {
            setTheme(R.style.DarkTheme)
        }
    }

    //Recreate Activity if the theme has changed
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==settingsCode) {
            this.recreate()
        }
    }

    //Change language
    private fun setLanguageOfApp() {
        val sharedPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        when {
            sharedPreferences.getString("app_language", "fr").equals("fr") -> {
                langManager.updateLanguageResources("fr")
            }
            sharedPreferences.getString("app_language", "fr").equals("de") -> {
                langManager.updateLanguageResources("de")
            }
            else -> {
                langManager.updateLanguageResources("en")
            }
        }
    }
}
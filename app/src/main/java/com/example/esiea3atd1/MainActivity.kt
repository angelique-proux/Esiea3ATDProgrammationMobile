package com.example.esiea3atd1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.tapadoo.alerter.Alerter

class MainActivity : AppCompatActivity() {

    private var SETTINGS_CODE = 243
    private lateinit var sharedpreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeOfApp()
        setContentView(R.layout.activity_main)

        //PreferenceManager.setDefaultValues(this, xml.root_preferences, false)
        /*setContentView(R.layout.fragment_menu)
        text_username = findViewById(R.id.menu_text)
        readSettings()*/

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
                startActivityForResult(intent, SETTINGS_CODE)
                true
            }
            R.id.action_notifications -> {
                Alerter.Companion.create(this)
                    .setTitle("Notification")
                    .setText("Hey you!")
                    .setIcon(R.drawable.ic_baseline_flight_24)
                    .setBackgroundColorRes(R.color.green1)
                    .setDuration(5000)
                    .setOnClickListener {
                        Toast.makeText(this, "Notification!", Toast.LENGTH_SHORT).show()
                    }
                    .show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    //Change theme
    private fun setThemeOfApp() {
        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        if(sharedpreferences.getString("theme_choice", "BRIGHT").equals("BRIGHT")) {
            setTheme(R.style.BrightTheme)
        } else {
            setTheme(R.style.DarkTheme)
        }
    }

    //Recreate Activity if the theme has changed
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==SETTINGS_CODE) {
            this.recreate()
        }
    }

}
package com.example.esiea3atd1.presentation

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class CountryApplication: Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        var context: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        context = this //à ne pas faire !!
    }
}
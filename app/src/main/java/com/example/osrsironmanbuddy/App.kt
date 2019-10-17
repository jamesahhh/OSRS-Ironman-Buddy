package com.example.osrsironmanbuddy

import android.app.Application
import com.example.osrsironmanbuddy.data.Prefs

val prefs: Prefs by lazy {
    App.prefs!!
}
class App: Application() {
    companion object {
        var prefs: Prefs? = null
    }

    override fun onCreate() {
        prefs = Prefs(applicationContext)
        super.onCreate()
    }
}
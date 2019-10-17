package com.example.osrsironmanbuddy.data

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    val PREFS_FILENAME = "com.example.osrsironmanbuddy.data.prefs"
    val TOPS = "tops"
    val MARKS = "marks"
    val BUCKETS = "buckets"
    val ESSENCE = "essence"
    val STAVES = "staves"
    val prefs: SharedPreferences = context.getSharedPreferences(PREFS_FILENAME, 0)

    var tops_collected: Int
        get() = prefs.getInt(TOPS, 0)
        set(value) = prefs.edit().putInt(TOPS, value).apply()

    var marks_collected: Int
        get() = prefs.getInt(MARKS, 0)
        set(value) = prefs.edit().putInt(MARKS, value).apply()

    var buckets_collected: Int
        get() = prefs.getInt(BUCKETS, 0)
        set(value) = prefs.edit().putInt(BUCKETS, value).apply()

    var essence_collected: Int
        get() = prefs.getInt(ESSENCE, 0)
        set(value) = prefs.edit().putInt(ESSENCE, value).apply()

    var staves_collected: Int
        get() = prefs.getInt(STAVES, 0)
        set(value) = prefs.edit().putInt(STAVES, value).apply()
}
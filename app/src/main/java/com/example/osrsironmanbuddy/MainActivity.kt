package com.example.osrsironmanbuddy

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.design.widget.Snackbar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {

        var mHandler = Handler(Looper.getMainLooper())

        daily_button.setOnClickListener {

            var mLaunchTask = Runnable {
                val intent = Intent(this, DailyRunActivity::class.java)
                intent.putExtra("run", "daily")
                startActivity(intent)
            }
            mHandler.postDelayed(mLaunchTask, 3000)
            Snackbar.make(it, "Launching Your Daily Ironman Run Tasks.... Get Ready!", Toast.LENGTH_LONG).setDuration(2500).show()

        }

        agility_button.setOnClickListener {
            var mLaunchTask = Runnable {
                val intent = Intent(this, AgilityActivity::class.java)
                intent.putExtra("run", "daily")
                startActivity(intent)
            }

            mHandler.postDelayed(mLaunchTask, 3000)
            Snackbar.make(it, "Launching the Agility Utilities Tracker....", Toast.LENGTH_LONG).setDuration(2500).show()
        }

        how_it_works.setOnClickListener {
            var mLaunchTask = Runnable {
                val intent = Intent(this, DescriptionActivity::class.java)
                intent.putExtra("app", "description")
                startActivity(intent)
            }

            mHandler.postDelayed(mLaunchTask, 3000)
            Snackbar.make(it, "Launching the Application Description....", Toast.LENGTH_LONG).setDuration(2500).show()

        }

        wiki_button.setOnClickListener {
            var mLaunchTask = Runnable {
                val intent = Intent(ACTION_VIEW, Uri.parse("https://oldschool.runescape.wiki/"))
                intent.putExtra("new_window", true)
                startActivity(intent)
            }
            mHandler.postDelayed(mLaunchTask, 2000)
            Snackbar.make(it, "Launching the OSRS Wiki Site...", Toast.LENGTH_LONG).setDuration(1500).show()
        }




    }
}

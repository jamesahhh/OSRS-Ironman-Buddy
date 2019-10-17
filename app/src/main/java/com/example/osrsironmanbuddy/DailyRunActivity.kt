package com.example.osrsironmanbuddy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.osrsironmanbuddy.fragments.CollectionFragment
import kotlinx.android.synthetic.main.activity_daily_run.*

class DailyRunActivity : AppCompatActivity() {

    private lateinit var locations: List<String>

    private lateinit var adapter: PagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daily_run)

        adapter = PagerAdapter(supportFragmentManager)

        when(intent.getStringExtra("run")) {
            "daily" -> {

                daily_title.text = getString(R.string.collection_run)
                locations = resources.getStringArray(R.array.daily_locations).toList()

                for(location in locations){
                    if(location == "Yanille" || location == "Varrock" || location == "Ardougne") {
                        adapter.addFragment(CollectionFragment.init(location, "bert", this.adapter), location)
                    }

                }
            }
        }

        view_pager.adapter = adapter
        all_tabs.setupWithViewPager(view_pager)
    }


}
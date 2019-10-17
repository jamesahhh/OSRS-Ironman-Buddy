package com.example.osrsironmanbuddy.fragments

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.ToggleButton
import com.example.osrsironmanbuddy.App
import com.example.osrsironmanbuddy.PagerAdapter
import com.example.osrsironmanbuddy.R
import kotlinx.android.synthetic.main.collection_entry.*

class CollectionFragment: Fragment() {

    private var location = ""
    private var image = ""
    private var root: View? = null
    private var adapter: PagerAdapter? = null
    private lateinit var prefs: SharedPreferences

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        if(root != null)
            return root

        val view: View = inflater.inflate(R.layout.fragment_location, container, false)
        var text_description = view.findViewById<TextView>(R.id.description_text)
        var image_view = view.findViewById<ImageView>(R.id.npc)
        var item_view = view.findViewById<ImageView>(R.id.collected_image)
        if(location == "Yanille") {
            text_description.setText(R.string.bert_text)
            image_view.setImageResource(R.drawable.bert)
            item_view.setImageResource(R.drawable.bucket_of_sand)
        }else if(location =="Varrock") {
            text_description.setText(R.string.zaff_text)
            image_view.setImageResource(R.drawable.zaff)
            item_view.setImageResource(R.drawable.battlestaff)
        }else if(location == "Ardougne") {
            text_description.setText(R.string.cromperty_text)
            image_view.setImageResource(R.drawable.wizard_cromperty)
            item_view.setImageResource(R.drawable.pure_essence)
        }
        root = view
        
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("TOTAL BUCKETS", App.prefs!!.buckets_collected.toString())
    }
    

    companion object {
        fun init(location: String, image: String, adapter: PagerAdapter): CollectionFragment {
            return CollectionFragment().apply {
                this.location = location
                this.image = image
                this.adapter = adapter
            }
        }
    }
}
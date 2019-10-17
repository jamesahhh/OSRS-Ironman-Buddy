package com.example.osrsironmanbuddy

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.todo.shakeit.core.ShakeIt
import com.todo.shakeit.core.ShakeListener
import kotlinx.android.synthetic.main.activity_agility.*

/**
 * This Class Utilizes an outside ShakeListener Library
 * GitHub Link: https://github.com/tushardhole/shakeit
 *
 * This was done to avoid lengthy boilerplate code
 */
class AgilityActivity : AppCompatActivity(), ShakeListener {

    private lateinit var current: String
    private lateinit var image: ImageView
    private lateinit var text: TextView
    private lateinit var counter: TextView
    private var markCount= App.prefs!!.marks_collected
    private var topCount = App.prefs!!.tops_collected

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agility)
        init()
        initImages()

    }

    override fun onBackPressed() {
        App.prefs!!.marks_collected = markCount
        App.prefs!!.tops_collected = topCount
        finish()
    }


    override fun onShake() {
        Toast.makeText(applicationContext, "Swapping the Agility Collectible being tracked!", Toast.LENGTH_LONG).show()
        swapCollectible(this.current)

    }

    private fun init(){
        ShakeIt.init(application)
        current = "pyramid"
        counter = findViewById(R.id.counter_view)
        changeCounterText()
        incrementer.setOnClickListener {
            if(this.current == "pyramid"){
                topCount++
                counter.text = topCount.toString()
            }else {
                markCount++
                counter.text = markCount.toString()
            }


        }

        decrementer.setOnClickListener {
            if(this.current == "pyramid"){
                if(topCount == 0){
                    Toast.makeText(applicationContext, "Fortunately you can't have a negative amount of Pyramid Tops silly!", Toast.LENGTH_LONG).show()
                }else {
                    topCount--
                }
                counter.text = topCount.toString()
            }else {
                if(markCount == 0){
                    Toast.makeText(applicationContext, "Fortunately you can't have a negative amount of Marks of Grace silly!", Toast.LENGTH_LONG).show()
                }else {
                    markCount--
                }

                counter.text = markCount.toString()
            }
        }
    }

    private fun initImages() {
        image = findViewById(R.id.collectible_image)
        text = findViewById(R.id.agility_description)
        image.setImageResource(R.drawable.pyramid_top)
        text.setText(R.string.pyramid_top_description)
    }

    private fun swapCollectible(current: String) {
        if(current == "pyramid"){
            image.setImageResource(R.drawable.mark_of_grace)
            text.setText(R.string.marks_of_grace_description)
            this.current = "marks"
            changeCounterText()
        }else {
            image.setImageResource(R.drawable.pyramid_top)
            text.setText(R.string.pyramid_top_description)
            this.current = "pyramid"
            changeCounterText()
        }
    }

    private fun changeCounterText() {
        if(this.current == "pyramid"){
            counter.text = topCount.toString()
        }else {
            counter.text = markCount.toString()
        }
    }


}

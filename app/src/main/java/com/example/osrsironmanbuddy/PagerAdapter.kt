package com.example.osrsironmanbuddy

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

//https://www.truiton.com/2015/06/android-tabs-example-fragments-viewpager/

class PagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager) {

    private val fragmentList = mutableListOf<Fragment>()
    private val fragmentListTitles = mutableListOf<String>()

    override fun getItem(pos : Int) : Fragment {
        return fragmentList[pos]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return fragmentListTitles[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentListTitles.add(title)
    }

}
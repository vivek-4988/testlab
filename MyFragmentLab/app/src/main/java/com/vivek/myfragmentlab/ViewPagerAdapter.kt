package com.vivek.myfragmentlab

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

/*
* //todo this class is for simple viewpager
* */
class ViewPagerAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

     val list = arrayListOf<Fragment>()

    fun add(fragment:Fragment){
        list.add(fragment)
    }

    override fun getCount(): Int = list.size

    override fun getItem(position: Int): Fragment {
        return list[position]
    }
}
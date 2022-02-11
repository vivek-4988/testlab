package com.vivek.myfragmentlab

import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
import androidx.viewpager2.adapter.FragmentStateAdapter

/*
* //todo this class is for viewpager2
* */
class ViewPager2Adapter(fm:FragmentActivity) : FragmentStateAdapter(fm) {

     val list = arrayListOf<Fragment>()

    fun add(fragment:Fragment){
        list.add(fragment)
    }

    override fun getItemCount(): Int = list.size

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}
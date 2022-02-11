package com.vivek.myfragmentlab

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.vivek.myfragmentlab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewPager = ViewPagerAdapter(supportFragmentManager).apply {
            add(FirstFragment())
            add(SecondFragment())
        }

        binding.viewPager.adapter = viewPager
        binding.viewPager.setPageTransformer(true,Transformation())


    }
}
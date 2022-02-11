package com.vivek.myfragmentlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.vivek.myfragmentlab.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewPager = ViewPager2Adapter(this).apply {
            add(FirstFragment())
            add(SecondFragment())
        }

        //todo viewpager2
        //
        binding.viewPager2.adapter = viewPager
        binding.viewPager2.setPageTransformer(TransformationVp2())

        //TODO simple viewpager
//        binding.viewPager.adapter = viewPager
//        binding.viewPager.setPageTransformer(true,Transformation())


    }
}
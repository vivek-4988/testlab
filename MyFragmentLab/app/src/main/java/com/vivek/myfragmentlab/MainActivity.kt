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

    }

    fun firstBtn(view: View) {
        //Simple way to add fragment into current activity
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, FirstFragment())
            .commit()
    }

    fun secondBtn(view: View) {
        //Simple way to add fragment into current activity
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, SecondFragment())
            .commit()
    }
}
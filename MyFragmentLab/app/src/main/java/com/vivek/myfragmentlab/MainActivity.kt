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

        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, SecondFragment())
            .commitNow()

    }

    fun firstBtn(view: View) {
        val bundle = Bundle()
        bundle.putString("PARAM", "Don't poke...")
        val fragment = SecondFragment()
        fragment.arguments = bundle
        //Simple way to add fragment into current activity
        supportFragmentManager.beginTransaction().replace(R.id.frameContainer, fragment)
            .commitNow()
    }
}
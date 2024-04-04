package com.example.colorsample.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colorsample.R
import com.example.colorsample.databinding.ActivityMainDetailsBinding
import com.example.colorsample.utils.IntentKeys
import com.example.colorsample.utils.ZERO_STRING


/**
 * Activity class responsible for displaying detailed information, typically HTML content.
 */
class MainDetailsActivity : AppCompatActivity() {

    // Private variable to store the HTML content received via intent
    private var param1: String? = null
    private lateinit var bind: ActivityMainDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main_details)

        // Retrieving HTML content from intent extras and setting it to the TextView
        intent?.let {
            param1 = it.getStringExtra(IntentKeys.htmlDetails)
            bind.details.text = param1
        }
    }

    companion object {
        /**
         * Function to launch this activity with optional HTML content parameter.
         * @param context The context from which the activity is launched.
         * @param details Optional HTML content to display in the activity.
         * @return Intent to launch the MainDetailsActivity.
         */
        fun launchActivity(
            context: Context,
            details: String = ZERO_STRING,
        ): Intent = Intent(context, MainDetailsActivity::class.java).apply {
            putExtra(IntentKeys.htmlDetails, details)
        }
    }
}
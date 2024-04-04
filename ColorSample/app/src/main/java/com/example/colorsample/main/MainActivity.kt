package com.example.colorsample.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.colorsample.R
import com.example.colorsample.dao.PublicAPI
import com.example.colorsample.dao.PublicAPIItem
import com.example.colorsample.databinding.ActivityMainBinding
import com.example.colorsample.network.ApiHelperRepo
import com.example.colorsample.network.com.example.sample.main.MainColorAdapter
import com.example.colorsample.utils.Utils
import com.example.colorsample.utils.isNetworkAvailable
import com.example.colorsample.utils.lazyViewModel
import com.example.colorsample.utils.setVisible
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Main entry point activity of the application.
 * This activity serves as the main screen of the app.
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Injected instance of ApiHelperRepo for API operations
    @Inject
    public lateinit var apiHelperRepo: ApiHelperRepo

    // Tag for logging purposes
    val TAG = "main"

    // View binding variable for the activity layout
    lateinit var bind: ActivityMainBinding

    // Lazy-initialized ViewModel instance using lazyViewModel extension function
    private val modelCall by lazyViewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set content view using view binding
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Check for network availability before proceeding
        if (isNetworkAvailable()) {
            // Show progress bar while fetching data
            bind.progressBar.setVisible(true)

            // Request color data from the API via ViewModel
            modelCall.requestColor()

            // Observe changes in color data from the ViewModel
            modelCall.colorsValue.observe(this) {
                try {
                    // Process the received data
                    val data: PublicAPI? = it
                    if (data != null) {
                        // Display color data in RecyclerView using adapter
                        bind.recycle.apply {
                            adapter = MainColorAdapter(data).apply {
                                // Handle item click to navigate to details screen
                                itemClick = { data: PublicAPIItem, i: Int ->
                                    val intent = MainDetailsActivity.launchActivity(
                                        this@MainActivity,
                                        data.description
                                    )
                                    startActivity(intent)
                                }
                            }
                        }
                        // Hide progress bar after data loading completes
                        bind.progressBar.setVisible(false)
                    } else {
                        // Handle incorrect or null response from API
                        Utils.printMsg("wrong response")
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
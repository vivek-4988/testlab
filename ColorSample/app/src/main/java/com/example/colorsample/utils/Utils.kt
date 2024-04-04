package com.example.colorsample.utils

import android.content.Context
import android.content.res.ColorStateList
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.example.colorsample.R
import java.lang.ref.WeakReference


/**
 * Utility class providing common functions for the Sample app.
 */
object Utils {

    /**
     * WeakReference to the application context.
     */
    private lateinit var con: WeakReference<Context>

    /**
     * Initializes the Utils class with the application context.
     */
    fun init(context: Context) {
        con = WeakReference(context)
    }

    /**
     * Displays a toast message with the given message string.
     */
    fun printMsg(msg: String?) {
        Toast.makeText(con.get(), msg, Toast.LENGTH_SHORT).show()
    }

    /**
     * Checks if the network is available.
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val nw = connectivityManager.activeNetwork ?: return false
        val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
        return when {
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            // For other devices that are able to connect with Ethernet
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            // For checking internet over Bluetooth
            actNw.hasTransport(NetworkCapabilities.TRANSPORT_BLUETOOTH) -> true
            else -> false
        }
    }

    /**
     * Returns a circular progress drawable.
     */
    fun getCircularProgressDrawable(context: Context): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(context)
        circularProgressDrawable.setTintList(
            ColorStateList.valueOf(
                ContextCompat.getColor(
                    context,
                    R.color.black
                )
            )
        )
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        return circularProgressDrawable
    }
}
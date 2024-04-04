package com.example.colorsample

import android.app.Application
import com.chuckerteam.chucker.api.ChuckerCollector
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.colorsample.utils.Utils
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleMyApp : Application() {

    companion object {
        /**
         * ChuckerInterceptor instance to intercept and inspect network calls.
         */
        lateinit var chuckerInterceptor: ChuckerInterceptor

        /**
         * Singleton instance of SampleMyApp.
         */
        lateinit var INSTANCE: SampleMyApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        // Initialize ChuckerCollector with the ApplicationContext
        val chuckerCollector = ChuckerCollector(
            context = applicationContext, // Use applicationContext here
            showNotification = true
        )

        // Initialize ChuckerInterceptor
        chuckerInterceptor = ChuckerInterceptor.Builder(this)
            .collector(chuckerCollector)
            .maxContentLength(250000L)
            .redactHeaders(emptySet())
            .alwaysReadResponseBody(true)
            .build()

        // Initialize Utils class
        Utils.init(this)
    }
}
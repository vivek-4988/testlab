package com.vivek.jetpacktest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.*
import com.vivek.jetpacktest.databinding.ActivityMainBinding
import com.vivek.jetpacktest.ui.MyWorker
import java.util.concurrent.TimeUnit

class MainWorkerActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.clickBtn.setOnClickListener {
            val constraints = Constraints.Builder().
                    setRequiredNetworkType(NetworkType.UNMETERED).build()
                //TODO work immediate
//            val worker = OneTimeWorkRequestBuilder<MyWorker>().
//            setConstraints(constraints)
//                .setInitialDelay(24,TimeUnit.HOURS)
//                .build()

                //TODO perodic interval minimum time required
//            val worker = PeriodicWorkRequestBuilder(1,1000)
//                .setConstraints(constraints)
//                .build()

            val worker = PeriodicWorkRequest.Builder(
                MyWorker::class.java, // Your worker class
                8, // repeating interval
                TimeUnit.HOURS,
                15, // flex interval - worker will run somewhen within this period of time, but at the end of repeating interval
                TimeUnit.MINUTES
            ).setConstraints(constraints).build()

            WorkManager.getInstance(this).enqueue(worker)
        }

    }
}
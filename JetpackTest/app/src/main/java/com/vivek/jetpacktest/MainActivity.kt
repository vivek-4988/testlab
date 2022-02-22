package com.vivek.jetpacktest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.vivek.jetpacktest.databinding.ActivityMainBinding
import com.vivek.jetpacktest.ui.MyWorker

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.clickBtn.setOnClickListener {
            val worker = OneTimeWorkRequestBuilder<MyWorker>().build()
            WorkManager.getInstance(this).enqueue(worker)
        }

    }
}
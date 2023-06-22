package com.vivek.mvvmexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vivek.mvvmexample.api.RetroFitHelper
import com.vivek.mvvmexample.repo.QuoteRepo
import com.vivek.mvvmexample.viewmodel.MainViewModel
import com.vivek.mvvmexample.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repo = QuoteRepo(RetroFitHelper.api);
        mainViewModel = ViewModelProvider(this,MainViewModelFactory(repo)).get(MainViewModel::class.java)

        mainViewModel.quotes.observe(this, Observer {
            Log.d("TAG", "onCreate: "+it.results.toString())
        })

    }
}
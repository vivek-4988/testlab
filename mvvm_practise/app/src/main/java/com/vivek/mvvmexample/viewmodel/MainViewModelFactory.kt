package com.vivek.mvvmexample.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vivek.mvvmexample.repo.QuoteRepo

class MainViewModelFactory(private val respo:QuoteRepo) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(respo) as T
    }
}
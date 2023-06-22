package com.vivek.mvvmexample.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.mvvmexample.models.QuoteList
import com.vivek.mvvmexample.repo.QuoteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(val respo:QuoteRepo) : ViewModel() {

    val quotes: LiveData<QuoteList>
        get() = respo.quotes

    init {
        viewModelScope.launch(Dispatchers.IO) {
            respo.getQuote(1)
        }
    }
}
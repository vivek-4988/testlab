package com.vivek.mvvmexample.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vivek.mvvmexample.api.QuoteService
import com.vivek.mvvmexample.models.QuoteList

class QuoteRepo(private val quoteService: QuoteService) {

    private val quoteLiveData = MutableLiveData<QuoteList>()
    val quotes:LiveData<QuoteList>
    get() = quoteLiveData

    suspend fun getQuote(page:Int){
        val result = quoteService.getQuotes(page)
        if (result?.body()!=null){
            quoteLiveData.postValue(result.body())
        }

    }

}
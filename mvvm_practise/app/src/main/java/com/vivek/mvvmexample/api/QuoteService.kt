package com.vivek.mvvmexample.api

import com.vivek.mvvmexample.models.QuoteList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteService {

    @GET("quotes?page=1")
    suspend fun getQuotes(@Query("page") page:Int): Response<QuoteList>
}
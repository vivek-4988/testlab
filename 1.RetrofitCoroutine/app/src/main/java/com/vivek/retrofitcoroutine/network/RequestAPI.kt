package com.vivek.retrofitcoroutine.network

import com.vivek.retrofitcoroutine.model.QuoteListDo
import retrofit2.Response
import retrofit2.http.GET

interface RequestAPI {

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteListDo>
}
package com.vivek.zoodmall.data.api

import com.google.gson.JsonObject
import com.vivek.mvvmsample.data.models.SearchUserDO
import com.vivek.mvvmsample.data.models.Users
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("users")
    suspend fun getUsers() : Response<List<Users>>

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") name  : String
    ) : Response<List<SearchUserDO>>


}

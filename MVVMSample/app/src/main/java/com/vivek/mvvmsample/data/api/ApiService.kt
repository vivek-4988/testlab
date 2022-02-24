package com.vivek.zoodmall.data.api

import com.vivek.mvvmsample.data.models.SearchUserDO
import com.vivek.mvvmsample.data.models.UsersItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET("users")
    suspend fun getUsers() : Response<List<UsersItem>>

    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") name  : String
    ) : Response<SearchUserDO>


}

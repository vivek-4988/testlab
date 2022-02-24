package com.vivek.mvvmsample.data.repo

import com.vivek.zoodmall.data.api.ApiService
import com.vivek.zoodmall.data.api.Client

object GitHubRepo {

    suspend fun getUsers() = Client.api.getUsers()

    suspend fun searchUsers(name:String) = Client.api.searchUsers(name)

}
package com.vivek.mvvmsample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vivek.mvvmsample.data.models.SearchUserDO
import com.vivek.mvvmsample.data.models.Users
import com.vivek.mvvmsample.data.repo.GitHubRepo
import kotlinx.coroutines.*

class GithubViewModel : ViewModel() {

    val users = MutableLiveData<List<Users>>()
    val searchUser = MutableLiveData<List<SearchUserDO>>()
    fun fetchUser() {
        runIO {
            val res = withContext(Dispatchers.IO) { GitHubRepo.getUsers() }
            if (res.isSuccessful) {
                res.body()?.let {
                    //users.value = (it) // this only work in main thread
                    users.postValue((it))
                }
            } else {

            }
        }
    }

    fun searchUser(name:String) {
        runIO {
            val res = withContext(Dispatchers.IO) { GitHubRepo.searchUsers(name) }
            if (res.isSuccessful) {
                res.body()?.let {
                    searchUser.postValue((it))
                }
            } else {

            }
        }
    }
}

fun ViewModel.runIO(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    function: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch(dispatcher) {
        function()
    }
}
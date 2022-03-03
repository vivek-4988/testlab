package com.vivek.mvvmsample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.vivek.mvvmsample.data.models.UsersItem
import com.vivek.mvvmsample.data.repo.GitHubRepo
import kotlinx.coroutines.*

class GithubViewModel : ViewModel() {

    val users = MutableLiveData<List<UsersItem>>()

    /*
    * TODO simple getting livedata
    * */
    fun fetchUser() {
        runIO {
            val res = withContext(Dispatchers.IO) { GitHubRepo.getUsers() }
            if (res.isSuccessful) {
                res.body()?.let {
                    //users.value = (it) // this only work in main thread
                    users.postValue((it))
                }
            }
        }
    }

    /*
    * TODO return data as livedata using emit
    * */
    fun searchUsers(name: String) = liveData(Dispatchers.IO) {
        val response = withContext(Dispatchers.IO) { GitHubRepo.searchUsers(name) }
        if (response.isSuccessful) {
            response.body()?.let {
                emit(it.items)
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
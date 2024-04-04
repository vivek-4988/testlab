package com.example.colorsample.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.colorsample.dao.PublicAPI
import com.example.colorsample.network.ApiHelperRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * ViewModel class for handling main screen data and operations.
 * This ViewModel communicates with the repository to fetch color data.
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val apiHelperRepo: ApiHelperRepo) : ViewModel() {

    // LiveData to hold the fetched color data
    val colorsValue = MutableLiveData<PublicAPI?>()

    /**
     * Function to request color data from the repository.
     * The function launches a coroutine in the IO dispatcher to perform the network request.
     */
    fun requestColor() {
        viewModelScope.launch {
            // Perform API call in IO dispatcher
            val res = withContext(Dispatchers.IO) { apiHelperRepo.color() }

            // Handle the response based on the HTTP status code
            when (res.code()) {
                200 -> {
                    // Handle a successful response with a status code of 200
                    val responseBody = res.body()
                    colorsValue.postValue(responseBody)
                }
                else -> {
                    // Handle other response codes
                    val data: PublicAPI? = null
                    colorsValue.postValue(data)
                }
            }
        }
    }
}
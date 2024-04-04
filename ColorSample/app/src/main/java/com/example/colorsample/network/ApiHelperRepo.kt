package com.example.colorsample.network

import javax.inject.Inject

/**
 * Repository class for handling API operations related to colors.
 * This class interacts with the ApiService to fetch color data.
 */
class ApiHelperRepo @Inject constructor(
    private val apiHelper: ApiService
) {

    /**
     * Suspended function to fetch color data from the API.
     * @return A Retrofit Response containing color data.
     */
    suspend fun color() = apiHelper.getColors()
}
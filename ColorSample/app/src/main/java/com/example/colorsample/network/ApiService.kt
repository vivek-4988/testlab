package com.example.colorsample.network

import com.example.colorsample.dao.PublicAPI
import com.example.colorsample.utils.ApiKeys
import retrofit2.Response
import retrofit2.http.GET

/**
 * Retrofit interface defining API endpoints for color-related operations.
 */
interface ApiService {

    /**
     * Suspended function to retrieve colors from the API.
     * @return Response containing color data wrapped in PublicAPI model.
     */
    @GET(ApiKeys.colors + "?format=json")
    suspend fun getColors(): Response<PublicAPI?>
}
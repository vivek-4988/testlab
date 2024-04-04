package com.example.colorsample.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkDI {

    /**
     * Provides the base URL for API requests.
     */
    @Provides
    fun baseUrl(): String = "http://www.colourlovers.com/api/"

    /**
     * Provides an instance of HttpLoggingInterceptor with logging level set to BODY.
     */
    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    /**
     * Provides an OkHttpClient instance with specified timeouts and interceptors.
     */
    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        val timeOut = 5 * 60

        return OkHttpClient.Builder()
            .connectTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            .readTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            .writeTimeout(timeOut.toLong(), TimeUnit.SECONDS)
            // Uncomment if myApp has chuckerInterceptor
//            .addInterceptor(myApp.chuckerInterceptor)
//            .addInterceptor(loggingInterceptor)
            .build()
    }

    /**
     * Provides a Retrofit instance for making API calls.
     */
    @Provides
    @Singleton
    fun retroBuilder(baseUrl: String, okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    /**
     * Provides the main ApiService interface for API operations.
     */
    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)
}
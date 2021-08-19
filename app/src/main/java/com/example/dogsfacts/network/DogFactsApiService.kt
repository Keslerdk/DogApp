package com.example.dogsfacts.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog-facts-api.herokuapp.com/api/v1/resources/"
//private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface DogFactsApiService {
    @GET("dogs?number=10")
    suspend fun getFacts(): String
}

object DogFactsApi {
    val retrofitService: DogFactsApiService by lazy {
        retrofit.create(DogFactsApiService::class.java)
    }
}
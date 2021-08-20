package com.example.dogsfacts.network

import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog-facts-api.herokuapp.com/api/v1/resources/"
//private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface DogFactsApiService {
    @GET("dogs?number=10")
    suspend fun getFacts(): List<DogFact>
}

object DogFactsApi {
    val retrofitService: DogFactsApiService by lazy {
        retrofit.create(DogFactsApiService::class.java)
    }
}
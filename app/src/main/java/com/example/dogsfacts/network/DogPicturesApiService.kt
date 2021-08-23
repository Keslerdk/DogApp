package com.example.dogsfacts.network

import android.icu.number.Scale
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dog.ceo/api/breed/hound/images/random/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface DogPicturesApiService {
    @GET("10")
    suspend fun getDogPicture() : String
}

object DogPictureApi {
    val retrofitService : DogPicturesApiService by lazy {
        retrofit.create(DogPicturesApiService::class.java)
    }
}
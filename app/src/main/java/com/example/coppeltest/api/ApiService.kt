package com.example.coppeltest.api

import com.example.coppeltest.BuildConfig
import com.example.coppeltest.data.Search
import retrofit2.Call
import com.example.coppeltest.data.SuperHeroForId
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*
import java.util.concurrent.TimeUnit

private val loggingInterceptor by lazy {
    val interceptor = HttpLoggingInterceptor()

    interceptor.level = if (BuildConfig.DEBUG) {
        HttpLoggingInterceptor.Level.BODY
    } else {
        HttpLoggingInterceptor.Level.NONE
    }

    interceptor
}

private val okHttpClient by lazy {
    val builder = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .readTimeout(100L, TimeUnit.SECONDS)
        .writeTimeout(100L, TimeUnit.SECONDS)
        .connectTimeout(100L, TimeUnit.SECONDS)
    builder.build()
}

private val moshi = Moshi.Builder()
    .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .baseUrl(BuildConfig.BASE_URL)
    .client(okHttpClient)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .build()

interface ApiService {

    @GET("{id}")
    suspend fun getSuperHero(
        @Path("id")id: String
    ): Response<SuperHeroForId>

    @GET("search/{name}")
    suspend fun getSuperHeroForSearch(
        @Path("name")name: String
    ): Response<Search>

}

object Api {
    val service: ApiService by lazy {
        retrofit.create(
            ApiService::class.java
        )
    }
}
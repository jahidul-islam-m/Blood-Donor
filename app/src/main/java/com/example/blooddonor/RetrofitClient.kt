package com.example.blooddonor

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient  {

companion object{

     private val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)



    val okHttpClint = OkHttpClient.Builder()
        .addInterceptor(logging)
        .readTimeout(1, TimeUnit.MINUTES)
        .writeTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(Interceptor { chain ->
            val builder = chain.request().newBuilder().apply {
                header("Accept", "application/json")
                header("Content-Type", "application/json")
            }
            return@Interceptor chain.proceed(builder.build())
        })
        .build()

    val retrofit=Retrofit.Builder()
        .baseUrl("http://103.69.150.122:9000/api/v1/")
        .client(okHttpClint)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api= retrofit.create(API::class.java)

}

}
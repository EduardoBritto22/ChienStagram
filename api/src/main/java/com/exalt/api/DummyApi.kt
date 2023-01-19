package com.exalt.api

import com.exalt.api.services.RemoteService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DummyApi {
    companion object {
        const val APP_ID = BuildConfig.API_ID
    }

    val remoteService: RemoteService

    init {

        //Add the header to all the requests
        val client = OkHttpClient.Builder().addInterceptor {requestChain ->
            val request = requestChain
                .request()
                .newBuilder()
                .addHeader("app-id" ,APP_ID)
                .build()

            requestChain.proceed(request)

        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummyapi.io/data/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        remoteService = retrofit.create(RemoteService::class.java)
    }

}
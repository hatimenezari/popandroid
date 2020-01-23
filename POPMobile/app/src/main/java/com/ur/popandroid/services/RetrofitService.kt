package com.ur.popandroid.services

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class  RetrofitService{

    companion object {
        private var retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("http://localhost:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun <S> cteateService(serviceClass: Class<S>?): S {
            return retrofit.create(serviceClass)
        }
    }


}

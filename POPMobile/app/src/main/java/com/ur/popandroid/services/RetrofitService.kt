package com.ur.popandroid.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class  RetrofitService{

    companion object {
        private var retrofit = Retrofit
            .Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun <S> createService(serviceClass: Class<S>): S {
            return retrofit.create(serviceClass)
        }
    }


}

package com.ur.popandroid.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class  RetrofitService{

    companion object {
        private var retrofit = Retrofit
            .Builder()
            .client(OkHttpClient.Builder().build())
            .baseUrl("https://3ac0d4a4.ngrok.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        fun <S> createService(serviceClass: Class<S>): S {
            return retrofit.create(serviceClass)
        }
    }


}

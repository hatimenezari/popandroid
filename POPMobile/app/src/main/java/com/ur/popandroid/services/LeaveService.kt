package com.ur.popandroid.services

import com.ur.popandroid.entities.Leave
import com.ur.popandroid.utils.GenericResponseList
import retrofit2.Call
import retrofit2.http.GET


interface LeaveService {

    @GET("leaves/")
    fun getLeaves(): Call<GenericResponseList<Leave>>
}


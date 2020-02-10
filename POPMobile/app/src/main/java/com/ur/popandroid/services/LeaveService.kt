package com.ur.popandroid.services

import com.ur.popandroid.entities.Leave
import com.ur.popandroid.utils.GenericResponseList
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path


interface LeaveService {

    @GET("leaves/")
    fun getLeaves(): Call<GenericResponseList<Leave>>

    @PUT("leaves/{id}")
    fun updateLeave(@Path("id") id: Int, @Body leave: Leave) : Call<ResponseBody>


    @GET("members/{id}/leaves")
    fun getMemberLeaves(@Path("id") id: Int): Call<GenericResponseList<Leave>>
}


package com.ur.popandroid.services

import com.ur.popandroid.entities.Leave
import com.ur.popandroid.utils.GenericResponseList
import com.ur.popandroid.entities.Member
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MemberService {

    @GET("members/")
    fun getMembers(): Call<GenericResponseList<Member>>


}


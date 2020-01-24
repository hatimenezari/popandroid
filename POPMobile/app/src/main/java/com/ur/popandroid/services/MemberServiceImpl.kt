package com.ur.popandroid.services

import androidx.lifecycle.MutableLiveData
import com.ur.popandroid.GenericResponseList
import com.ur.popandroid.entities.Member
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET


interface MemberService {

    @GET("members/")
    fun getMembers(): Call<GenericResponseList<Member>>
}

class MemberRepository private constructor() {
    private val memberService: MemberService = RetrofitService.createService(MemberService::class.java)

    fun getMembers(): MutableLiveData<List<Member>>? {
        val members: MutableLiveData<List<Member>> = MutableLiveData()
        memberService.getMembers().enqueue(object : Callback<GenericResponseList<Member>> {
            override fun onFailure(call: Call<GenericResponseList<Member>>, t: Throwable) {
                members.value = null
            }

            override fun onResponse(call: Call<GenericResponseList<Member>>, response: Response<GenericResponseList<Member>>) {
                if(response.isSuccessful){
                    members.value = response.body()?.content
                }
            }
        })
        return members
    }


    companion object {
        private var memberRepository: MemberRepository? = null
        val instance: MemberRepository
            get() {
                if (memberRepository == null) {
                    memberRepository = MemberRepository()
                }
                return memberRepository as (MemberRepository)
            }
    }

}


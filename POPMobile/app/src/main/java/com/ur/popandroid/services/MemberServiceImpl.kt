package com.ur.popandroid.services

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.ur.popandroid.entities.Member
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET


interface MemberService {

    @GET("/members/")
    fun getMembers(): Call<List<Member>>
}

class MemberRepository private constructor() {
    private val memberService: MemberService = RetrofitService.cteateService(MemberService::class.java)

    fun getMembers(): MutableLiveData<List<Member>>? {
        val members: MutableLiveData<List<Member>> = MutableLiveData()
        memberService.getMembers().enqueue(object : Callback<List<Member>> {
            override fun onFailure(call: Call<List<Member>>, t: Throwable) {
                members.value = null
            }

            override fun onResponse(call: Call<List<Member>>, response: Response<List<Member>>) {
                if(response.isSuccessful)
                    members.value = response.body()
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


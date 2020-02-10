package com.ur.popandroid.Repositories

import androidx.lifecycle.MutableLiveData
import com.ur.popandroid.utils.GenericResponseList
import com.ur.popandroid.entities.Member
import com.ur.popandroid.services.MemberService
import com.ur.popandroid.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MemberRepository {
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

}


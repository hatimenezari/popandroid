package com.ur.popandroid.services

import androidx.lifecycle.MutableLiveData
import com.ur.popandroid.Repositories.MemberRepository
import com.ur.popandroid.entities.Member
import com.ur.popandroid.utils.GenericResponseList
import org.junit.Test


class MemberRepositoryTest {

    val members = listOf(
        Member(
            1,
            "hatim",
            "10-04-1995",
            "america/denver",
            "out sick",
            "0634563289",
            "14/01/2020",
            "software engineer"
        )
    )

 /*   @Test
    fun getMembers() {


        val memberRepository = MemberRepository.instance
        val memberService = Mockito.mock(MemberService::class.java)
        `when`(memberService.getMembers()).thenReturn(Calls.response(GenericResponseList(members)))
        val returnedMembers = memberRepository.getMembers()?.value
        // assert TODO
    }*/

}



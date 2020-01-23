package com.ur.popandroid.services

import com.ur.popandroid.R
import com.ur.popandroid.entities.Member




class MemberService {

     fun getMembersList(): List<Member>{
        //call to api to be implemented here
        val members  = listOf<Member>(

            Member(R.drawable.oval1, "filler name",  "ENJOYING LIFE","12:13 PM"),
            Member(R.drawable.oval2, "filler name",  "AVAILABLE", "12:13 PM"),
            Member(R.drawable.oval3, "filler name", "OUT SICK","12:13 PM"),
            Member(R.drawable.oval4, "filler name",  "AWAY", "12:13 PM")
        )
        return members
    }
}
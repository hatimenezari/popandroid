package com.ur.popandroid.entities

import java.util.*

data class Member(
    val id: Int,
    val name: String,
    val companyAnniversary: String,
    val timeZone: TimeZone,
    val availability: String,
    val phone: String,
    val startingDate:String,
    val companyRole:String
    )
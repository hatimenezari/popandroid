package com.ur.popandroid.entities

data class Member(
    val id: Int,
    val name: String,
    val companyAnniversary: String,
    val timeZone: String,
    val availability: String,
    val phone: String,
    val startingDate:String,
    val companyRole:String
    )
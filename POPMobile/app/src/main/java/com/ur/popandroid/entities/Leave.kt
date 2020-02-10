package com.ur.popandroid.entities


data class Leave(
    val id: Int,
    val date: String,
    val startingDate: String,
    val endingDate: String,
    val duration: String,
    val status: String,
    val reason:String,
    val member: Member
)
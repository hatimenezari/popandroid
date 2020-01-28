package com.ur.popandroid.entities

import java.time.LocalDate

data class Leave(
    val id: Int,
    val avatar: String,
    val type: String,
    val date: String,
    val startingDate: LocalDate,
    val endingDate: LocalDate,
    val duration: String,
    val status: String,
    val reason:String
)
package com.ur.popandroid.entities

import android.os.Parcel
import android.os.Parcelable


data class Member(
    val id: Int,
    val name: String,
    val companyAnniversary: String,
    val timeZone: String,
    val availability: String,
    val phone: String,
    val startingDate:String,
    val companyRole:String,
    val avatarURI: String,
    val email: String,
    val bio: String
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!,
        parcel.readString() !!
    )
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(companyAnniversary)
        parcel.writeString(timeZone)
        parcel.writeString(availability)
        parcel.writeString(phone)
        parcel.writeString(startingDate)
        parcel.writeString(companyRole)
        parcel.writeString(avatarURI)
        parcel.writeString(email)
        parcel.writeString(bio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Member> {
        override fun createFromParcel(parcel: Parcel): Member {
            return Member(parcel)
        }

        override fun newArray(size: Int): Array<Member?> {
            return arrayOfNulls(size)
        }
    }
}
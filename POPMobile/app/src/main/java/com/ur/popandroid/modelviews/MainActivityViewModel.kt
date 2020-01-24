package com.ur.popandroid.modelviews

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.ur.popandroid.entities.Member
import com.ur.popandroid.services.MemberRepository


class MainActivityViewModel : ViewModel() {
    private var mutableLiveData: MutableLiveData<List<Member>>? = null
    private lateinit var memberRepository: MemberRepository
    fun init() {
        if (mutableLiveData != null) {
            return
        }
        memberRepository = MemberRepository.instance
        mutableLiveData = memberRepository.getMembers()
    }

    fun getMembers(): LiveData<List<Member>>? {
        return mutableLiveData
    }
}
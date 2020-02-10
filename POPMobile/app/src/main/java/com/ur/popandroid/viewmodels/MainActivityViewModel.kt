package com.ur.popandroid.viewmodels

import androidx.lifecycle.LiveData

import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.ur.popandroid.Repositories.MemberRepository
import com.ur.popandroid.entities.Member


class MainActivityViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<List<Member>>? = null
    private var memberRepository: MemberRepository = MemberRepository

    init {
        if (mutableLiveData == null)
            mutableLiveData = memberRepository.getMembers()
    }

    //observable of members
    fun getMembers(): LiveData<List<Member>>? {
        return mutableLiveData
    }
}
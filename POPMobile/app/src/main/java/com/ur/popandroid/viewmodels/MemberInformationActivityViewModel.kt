package com.ur.popandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ur.popandroid.Repositories.LeaveRepository
import com.ur.popandroid.entities.Leave

class MemberInformationActivityViewModel : ViewModel() {


    private val leaveRepository: LeaveRepository = LeaveRepository
    private var mutableLiveData: MutableLiveData<List<Leave>>? = null

    //observable of a member's leave
    fun getLeaves(id : Int): LiveData<List<Leave>>? {
        if(mutableLiveData == null)
            mutableLiveData = leaveRepository.getMemberLeaves(id)
        return mutableLiveData
    }
}
package com.ur.popandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ur.popandroid.Repositories.LeaveRepository
import com.ur.popandroid.entities.Leave


class LeavesActivityViewModel : ViewModel() {

    private var mutableLiveData: MutableLiveData<List<Leave>>? = null
    private var leaveRepository: LeaveRepository = LeaveRepository

    init {
        if (mutableLiveData == null)
            mutableLiveData = leaveRepository.getLeaves()
    }

    fun getLeaves(): LiveData<List<Leave>>? {
        return mutableLiveData
    }
}
package com.ur.popandroid.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ur.popandroid.Repositories.LeaveRepository
import com.ur.popandroid.entities.Leave


class LeavesActivityViewModel : ViewModel() {


    private var leaveRepository: LeaveRepository = LeaveRepository
    private var mutableLiveData: MutableLiveData<List<Leave>>? = leaveRepository.getLeaves()


    fun getLeaves(): LiveData<List<Leave>>? {
        return mutableLiveData
    }

    fun updateLeave(leave:Leave, lambda: () -> Unit){
        leaveRepository.updateLeave(leave) {
            reload()
            lambda.invoke()
        }
    }

    fun reload(){
        mutableLiveData = leaveRepository.getLeaves()
    }
}
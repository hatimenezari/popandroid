package com.ur.popandroid.Repositories

import androidx.lifecycle.MutableLiveData
import com.ur.popandroid.entities.Leave
import com.ur.popandroid.services.LeaveService
import com.ur.popandroid.services.RetrofitService
import com.ur.popandroid.utils.GenericResponseList
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object LeaveRepository {
    private val leaveService: LeaveService = RetrofitService.createService(LeaveService::class.java)

    fun getLeaves(): MutableLiveData<List<Leave>>? {
        val leaves: MutableLiveData<List<Leave>> = MutableLiveData()
        leaveService.getLeaves().enqueue(object : Callback<GenericResponseList<Leave>> {
            override fun onFailure(call: Call<GenericResponseList<Leave>>, t: Throwable) {
                leaves.value = null
            }

            override fun onResponse(
                call: Call<GenericResponseList<Leave>>,
                response: Response<GenericResponseList<Leave>>
            ) {
                leaves.value = response.body()?.content
            }
        })
        return leaves
    }

    fun updateLeave(leave: Leave, lambda : () -> Unit){
        leaveService.updateLeave(leave.id, leave).enqueue(object : Callback<ResponseBody>{
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                //TODO failure case
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                lambda.invoke()
            }

        })
    }
}
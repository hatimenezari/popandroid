package com.ur.popandroid.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ur.popandroid.R
import com.ur.popandroid.entities.Leave
import kotlinx.android.synthetic.main.card_leave.view.*

class LeaveAdapter(val leaves: List<Leave>) : RecyclerView.Adapter<LeaveAdapter.LeaveViewHolder>() {
    inner class LeaveViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var avatar: ImageView
        var name : TextView
        var date: TextView
        var duration: TextView
        var startingDate : TextView
        var endingDate : TextView
        var reason: TextView

        init {
            avatar = v.card_img_avatar
            name= v.card_text_name
            date= v.card_text_date
            duration= v.card_txt_duration
            startingDate= v.card_txt_starting_date
            endingDate= v.card_txt_ending_date
            reason = v.card_txt_reason
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveViewHolder {
        val leaveCard : View = LayoutInflater.from(parent.context).inflate(R.layout.card_leave, parent, false)
        return LeaveViewHolder(leaveCard)
    }

    override fun getItemCount() = leaves.size


    override fun onBindViewHolder(holder: LeaveViewHolder, position: Int) {
        val currentLeave = leaves[position]

        holder.avatar.setImageResource(R.drawable.oval2)
        holder.name.text = "test"
        holder.endingDate.text = currentLeave.endingDate.toString()
        holder.startingDate.text = currentLeave.startingDate.toString()
        holder.duration.text = currentLeave.duration
        holder.date.text = currentLeave.date
        holder.reason.text = currentLeave.reason
    }
}
package com.ur.popandroid.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.ur.popandroid.R
import com.ur.popandroid.entities.Leave
import kotlinx.android.synthetic.main.card_leave.view.*

class LeaveAdapter(val leaves: List<Leave>, var lambda: ((Leave) -> (Unit))) : RecyclerView.Adapter<LeaveAdapter.LeaveViewHolder>() {


    inner class LeaveViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var avatar: ImageView = v.card_img_avatar
        var name : TextView = v.card_text_name
        var date: TextView = v.card_text_date
        var duration: TextView = v.card_txt_duration
        var startingDate : TextView = v.card_txt_starting_date
        var endingDate : TextView = v.card_txt_ending_date
        var reason: TextView = v.card_txt_reason

        init{
            v.card_btn_approve.setOnClickListener { v ->
                run {
                    leaves[adapterPosition].status = "Approved"
                    lambda.invoke(leaves[adapterPosition])
                }
            }
            v.card_btn_refuse.setOnClickListener { v ->
                run {
                    leaves[adapterPosition].status = "Denied"
                    lambda.invoke(leaves[adapterPosition])
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveViewHolder {
        val leaveCard : View = LayoutInflater.from(parent.context).inflate(R.layout.card_leave, parent, false)
        return LeaveViewHolder(leaveCard)
    }

    override fun getItemCount() = leaves.size

    override fun onBindViewHolder(holder: LeaveViewHolder, position: Int) {
        val currentLeave = leaves[position]

        Glide.with(holder.avatar.context)
            .load(currentLeave.member.avatarURI)
            .transform(CircleCrop())
            .into(holder.avatar)
        holder.name.text = currentLeave.member.name
        holder.startingDate.text = "From\n${currentLeave.startingDate}"
        holder.endingDate.text = "To\n${currentLeave.endingDate}"
        holder.duration.text = currentLeave.duration + " Days"
        holder.date.text = currentLeave.date
        holder.reason.text = currentLeave.reason
    }

}
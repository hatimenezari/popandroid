package com.ur.popandroid.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.ur.popandroid.R
import com.ur.popandroid.entities.Leave
import kotlinx.android.synthetic.main.card_history_leave.view.*
import java.text.SimpleDateFormat

class LeaveHistoryAdapter(val leaves: List<Leave>) : RecyclerView.Adapter<LeaveHistoryAdapter.LeaveHistoryViewHolder>() {
    inner class LeaveHistoryViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var avatar: ImageView
        var name : TextView
        var duration : TextView
        var startingDate: TextView
        var time: TextView
        var status: TextView

        init {
            avatar = v.card_history_leave_img_avatar
            name= v.card_history_leave_text_name
            duration= v.card_history_leave_txt_duration
            startingDate= v.card_history_leave_txt_starting_date
            time= v.card_history_leave_txt_time
            status = v.card_history_leave_txt_status
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeaveHistoryViewHolder {
        val leaveHistoryCard : View = LayoutInflater.from(parent.context).inflate(R.layout.card_history_leave, parent, false)
        return LeaveHistoryViewHolder(leaveHistoryCard)
    }

    override fun getItemCount() = leaves.size


    override fun onBindViewHolder(holder: LeaveHistoryViewHolder, position: Int) {
        val currentLeave = leaves[position]

        Glide.with(holder.avatar.context)
            .load(currentLeave.member.avatarURI)
            .transform(CircleCrop())
            .into(holder.avatar)
        holder.name.text = currentLeave.member.name
        holder.startingDate.text = SimpleDateFormat("MMM. dd, yyyy ").format(
            SimpleDateFormat("yyyy-MM-dd").parse(currentLeave.startingDate)
        )
        holder.duration.text = currentLeave.duration + " days,"
        holder.status.text = currentLeave.status
        holder.status.setBackgroundColor(getStatusColor(holder, currentLeave.status, "background"))
        holder.status.setTextColor(getStatusColor(holder, currentLeave.status, "text"))
    }

    fun getStatusColor(holder: LeaveHistoryViewHolder, status : String, type: String): Int{
        return when(status){
            "Pending" ->  ContextCompat.getColor(holder.itemView.context, when(type) {
                "background" -> R.color.pendingBackground
                else -> R.color.pendingText
            } )
            "Denied" ->  ContextCompat.getColor(holder.itemView.context,  when(type) {
                "background" -> R.color.deniedBackground
                else -> R.color.deniedText
            } )
            "Approved" ->  ContextCompat.getColor(holder.itemView.context,  when(type) {
                "background" -> R.color.approvedBackground
                else -> R.color.approvedText
            } )
            else -> 0
        }
    }
}
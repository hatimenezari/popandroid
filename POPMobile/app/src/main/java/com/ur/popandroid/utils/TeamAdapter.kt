package com.ur.popandroid.utils

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.ur.popandroid.MemberInformationActivity
import com.ur.popandroid.R
import com.ur.popandroid.entities.Member
import com.ur.popandroid.utils.Constants.Companion.MEMBER
import com.ur.popandroid.utils.Constants.Companion.availableEmoji
import com.ur.popandroid.utils.Constants.Companion.awayEmoji
import com.ur.popandroid.utils.Constants.Companion.sickEmoji
import com.ur.popandroid.utils.Constants.Companion.vacationEmoji
import java.text.SimpleDateFormat
import java.util.*


class TeamAdapter(val members: List<Member>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    inner class TeamViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var memberPicture: ImageView = v.findViewById(R.id.card_img_pic)
        var name: TextView = v.findViewById(R.id.card_txt_name)
        var time: TextView = v.findViewById(R.id.card_txt_time)
        var state: TextView = v.findViewById(R.id.card_txt_state)

        init {
            v.setOnClickListener { v -> showDetails(v, members[adapterPosition])}
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val memberCard: View =
            LayoutInflater.from(parent.context).inflate(R.layout.card_member, parent, false)
        return TeamViewHolder(memberCard)
    }

    override fun getItemCount() = members.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val currentMember: Member = members[position]

        Glide.with(holder.memberPicture.context)
            .load(currentMember.avatarURI)
            .transform(CircleCrop())
            .into(holder.memberPicture)
        holder.name.text = currentMember.name
        val date = Date()
        val df = SimpleDateFormat("HH:mm:ss")
        df.timeZone = TimeZone.getTimeZone(currentMember.timeZone)
        holder.time.text =  df.format(date)
        holder.state.text = getState(currentMember.availability)
    }

    fun getState(state: String) :String{
        var stateString = ""
        when(state){
            "AVAILABLE" -> stateString += String(Character.toChars(availableEmoji)) + " Available"
            "AWAY" -> stateString += String(Character.toChars(awayEmoji)) + " Away"
            "OUT_SICK" -> stateString += String(Character.toChars(sickEmoji)) + " Out sick"
            "ENJOYING_LIFE" -> stateString += String(Character.toChars(vacationEmoji)) + " Enjoying Life"
        }
        return stateString
    }

    fun showDetails(v:View, member: Member){
        val intent = Intent(v.context, MemberInformationActivity::class.java)
        intent.putExtra(MEMBER, member)
        startActivity(v.context, intent, null)
    }
}
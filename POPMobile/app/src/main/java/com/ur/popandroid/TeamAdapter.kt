package com.ur.popandroid

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import entities.Member
import java.time.LocalTime

class TeamAdapter(val members: List<Member>) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {
    class TeamViewHolder : RecyclerView.ViewHolder {
        var memberPicture: ImageView
        var name : TextView
        var time : TextView
        var state : TextView

        constructor(v: View) : super(v) {
            memberPicture = v.findViewById(R.id.card_img_pic)
            name = v.findViewById(R.id.card_txt_name)
            time = v.findViewById(R.id.card_txt_time)
            state = v.findViewById(R.id.card_txt_state)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val memberCard : View = LayoutInflater.from(parent.context).inflate(R.layout.card_member, parent, false)
        return TeamViewHolder(memberCard)
    }

    override fun getItemCount() = members.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
         val currentMember: Member = members[position]

        holder.memberPicture.setImageResource(currentMember.pictureRessource)
        holder.name.text = currentMember.name
        holder.time.text = currentMember.time
        holder.state.text = currentMember.state
    }
}
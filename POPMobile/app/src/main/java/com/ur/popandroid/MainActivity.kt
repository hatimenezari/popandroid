package com.ur.popandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ur.popandroid.services.MemberService

class MainActivity : AppCompatActivity() {

    private lateinit var rclvTeam: RecyclerView
    private lateinit var teamAdapter: RecyclerView.Adapter<TeamAdapter.TeamViewHolder>
    private lateinit var  teamLayoutManager: RecyclerView.LayoutManager
    private lateinit var memberService: MemberService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        memberService = MemberService()
        val members = memberService.getMembersList()

        rclvTeam = findViewById(R.id.main_rclv_team)
        teamLayoutManager = LinearLayoutManager(this)
        teamAdapter = TeamAdapter(members)

        rclvTeam.adapter = teamAdapter
        rclvTeam.layoutManager = teamLayoutManager
    }

    fun seeInfo(v:View):Unit{

    }
}

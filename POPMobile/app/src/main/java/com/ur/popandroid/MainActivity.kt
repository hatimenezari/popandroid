package com.ur.popandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ur.popandroid.entities.Member
import com.ur.popandroid.modelviews.MainActivityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var rclvTeam: RecyclerView
    private lateinit var teamAdapter: RecyclerView.Adapter<TeamAdapter.TeamViewHolder>
    private lateinit var  teamLayoutManager: RecyclerView.LayoutManager
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val members: MutableList<Member> = ArrayList()

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.init()
        mainActivityViewModel.getMembers()?.observe(this, Observer {
            if(it != null)
                members.addAll(it)
            teamAdapter = TeamAdapter(members)
            rclvTeam.adapter = teamAdapter
        })

        rclvTeam = findViewById(R.id.main_rclv_team)
        teamLayoutManager = LinearLayoutManager(this)



        rclvTeam.layoutManager = teamLayoutManager
    }

    fun seeInfo(v:View){
        //to be implemented
    }
}

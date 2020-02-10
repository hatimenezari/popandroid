package com.ur.popandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ur.popandroid.R
import com.ur.popandroid.entities.Member
import com.ur.popandroid.utils.TeamAdapter
import com.ur.popandroid.viewmodels.MainActivityViewModel
import kotlinx.android.synthetic.main.action_bar.*


class MainActivity : AppCompatActivity() {

    private lateinit var rclvTeam: RecyclerView
    private lateinit var teamAdapter: RecyclerView.Adapter<TeamAdapter.TeamViewHolder>
    private lateinit var  teamLayoutManager: RecyclerView.LayoutManager
    private lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getMembers()?.observe(this, Observer {
            val members: MutableList<Member> = ArrayList()
            if(it != null)
                members.addAll(it)
            teamAdapter = TeamAdapter(members)
            rclvTeam.adapter = teamAdapter
        })

        rclvTeam = findViewById(R.id.main_rclv_team)
        teamLayoutManager = LinearLayoutManager(this)

        rclvTeam.layoutManager = teamLayoutManager
        btn_team.setColorFilter(R.color.colorPrimaryLight)
    }

    fun checkLeaves(v: View){
        intent = Intent(this, LeavesActivity::class.java)
        startActivity(intent)
    }
}

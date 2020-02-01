package com.ur.popandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ur.popandroid.entities.Leave
import com.ur.popandroid.utils.LeaveAdapter
import com.ur.popandroid.viewmodels.LeavesActivityViewModel
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.activity_leaves.*

class LeavesActivity : AppCompatActivity() {

    private lateinit var rclvLeave: RecyclerView
    private lateinit var leaveAdapter: RecyclerView.Adapter<LeaveAdapter.LeaveViewHolder>
    private lateinit var  leaveLayoutManager: RecyclerView.LayoutManager
    private lateinit var leavesActivityViewModel : LeavesActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaves)

        rclvLeave = leaves_rclv
        leavesActivityViewModel = ViewModelProviders.of(this).get(LeavesActivityViewModel::class.java)
        leavesActivityViewModel.getLeaves()?.observe(this, Observer {
            val leaves: MutableList<Leave> = ArrayList()
            if(it != null)
                leaves.addAll(it)
            leaveAdapter = LeaveAdapter(leaves)
            rclvLeave.adapter = leaveAdapter
        })


        leaveLayoutManager = LinearLayoutManager(this)

        rclvLeave.layoutManager = leaveLayoutManager
        btn_leaves.setColorFilter(R.color.colorPrimaryLight)
    }

    fun checkTeam(v: View){
        intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

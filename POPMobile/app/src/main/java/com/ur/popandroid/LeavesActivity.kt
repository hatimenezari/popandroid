package com.ur.popandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ur.popandroid.entities.Leave
import com.ur.popandroid.utils.LeaveAdapter
import kotlinx.android.synthetic.main.activity_leaves.*
import java.time.LocalDate

class LeavesActivity : AppCompatActivity() {

    private lateinit var rclvLeave: RecyclerView
    private lateinit var leaveAdapter: RecyclerView.Adapter<LeaveAdapter.LeaveViewHolder>
    private lateinit var  leaveLayoutManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_leaves)

        rclvLeave = leaves_rclv
        val leaves: List<Leave> = listOf(
            Leave(
            1,
            "test",
            "test",
            "test",
            LocalDate.now(),
            LocalDate.now(),
            "6 Days",
            "pending",
            "i wanna go home!!"
        ),
            Leave(
                2,
                "test",
                "test",
                "test",
                LocalDate.now(),
                LocalDate.now(),
                "6 Days",
                "pending",
                "i wanna go home!!"
            )

        )

        leaveAdapter = LeaveAdapter(leaves)
        rclvLeave.adapter = leaveAdapter
        leaveLayoutManager = LinearLayoutManager(this)

        rclvLeave.layoutManager = leaveLayoutManager
    }
}

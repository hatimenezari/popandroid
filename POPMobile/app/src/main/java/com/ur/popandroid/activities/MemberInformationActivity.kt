package com.ur.popandroid.activities

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.mancj.slideup.SlideUp
import com.mancj.slideup.SlideUpBuilder
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.ur.popandroid.R
import com.ur.popandroid.entities.Leave
import com.ur.popandroid.entities.Member
import com.ur.popandroid.utils.Constants.Companion.MEMBER
import com.ur.popandroid.utils.DaySelector
import com.ur.popandroid.utils.WorkDaySelector
import com.ur.popandroid.viewmodels.MemberInformationActivityViewModel
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.activity_member_information.*
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.ZoneId
import java.util.*


class MemberInformationActivity : AppCompatActivity() {

    private lateinit var member : Member
    private lateinit var slideUp: SlideUp
    private lateinit var memberInformationActivityViewModel : MemberInformationActivityViewModel
    private val formatter = SimpleDateFormat("yyyy-MM-dd")
    var sickDays = 0
    var leaveDays = 0
    var nationalDays = 0
    var workDays = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_information)

        memberInformationActivityViewModel = ViewModelProviders.of(this).get(MemberInformationActivityViewModel::class.java)

        member = intent.getParcelableExtra(MEMBER)

        Glide.with(this)
            .load(member.avatarURI)
            .transform(CircleCrop())
            .into(info_img_avatar)
        info_txt_anniversary.text = member.companyAnniversary
        info_txt_date.text = member.startingDate
        info_txt_email.text = member.email
        info_txt_name.text = member.name
        info_txt_phone.text = member.phone
        val date = Date()
        val df = SimpleDateFormat("HH:mm:ss")
        df.timeZone = TimeZone.getTimeZone(member.timeZone)
        info_txt_timezone.text =  "${df.format(date)} Local time"
        info_txt_bio.text = member.bio
        btn_team.setColorFilter(R.color.colorPrimaryLight)
        val slideView : View = slideup_lyt_calendar
        slideView.bringToFront()
        slideUp =  SlideUpBuilder(slideView)
            .withStartState(SlideUp.State.HIDDEN)
            .withStartGravity(Gravity.BOTTOM)
            .build()


    }

    fun onBack(v: View) {
        finish()
    }

    fun slideUp(v : View){
        memberInformationActivityViewModel.getLeaves(member.id)?.observe(this, Observer{

                member_information_cldr_leaves.addDecorator(WorkDaySelector(this))
                member_information_cldr_leaves.selectionMode = MaterialCalendarView.SELECTION_MODE_NONE

                it.stream().filter { l -> (formatter.parse(l.endingDate)
                    .toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate().isAfter(LocalDate.now().withDayOfMonth(1))
                        )}.forEach { l->
                    markDays(l)
                }
        })
        slideUp.show()
    }

    private fun markDays(l: Leave) {

        val startDate = formatter.parse(l.startingDate)
        val endDate = formatter.parse(l.endingDate)

        val start: LocalDate = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        val end: LocalDate = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()


        var date = if(start.isBefore(LocalDate.now().withDayOfMonth(1))) LocalDate.now().withDayOfMonth(1) else start
        while (date.isBefore(end.plusDays(1))) {
            val dayOfWeek = date.dayOfWeek
            if(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY ){
                date = date.plusDays(1)
                continue
            }

            member_information_cldr_leaves.addDecorator(DaySelector(this , CalendarDay.from(date.year, date.monthValue, date.dayOfMonth), l.type))
            if (l.type.equals("Sick")){
              sickDays += 1
            }
            else if(l.type.equals("Vacation")){
                leaveDays += 1
            }

            date = date.plusDays(1)
        }

        member_information_txt_national_days.text = "0"
        member_information_txt_leave_days.text = leaveDays.toString()
        member_information_txt_sick_days.text = sickDays.toString()
        member_information_txt_work_days.text = "10"
    }
}

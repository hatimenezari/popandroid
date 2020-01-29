package com.ur.popandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.ur.popandroid.entities.Member
import com.ur.popandroid.utils.Constants.Companion.MEMBER
import kotlinx.android.synthetic.main.action_bar.*
import kotlinx.android.synthetic.main.activity_member_information.*
import java.text.SimpleDateFormat
import java.util.*

class MemberInformationActivity : AppCompatActivity() {

    private lateinit var member : Member

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_member_information)

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
    }

    fun onBack(v: View) {
        finish()
    }
}

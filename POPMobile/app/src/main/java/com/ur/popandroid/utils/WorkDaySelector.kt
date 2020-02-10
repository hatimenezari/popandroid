package com.ur.popandroid.utils



import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.ur.popandroid.R
import java.text.SimpleDateFormat
import java.util.*


class WorkDaySelector(val context: Activity) : DayViewDecorator {
    private var drawable: Drawable? = null

    init {
        drawable =   ContextCompat.getDrawable(context, R.drawable.work)
    }


    override fun shouldDecorate(day: CalendarDay?): Boolean {
        val c = Calendar.getInstance()
        val formatter = SimpleDateFormat("yyyy-MM-dd")
        val dateString = "${day!!.year}-${day.month}-${day!!.day}"
        c.time = formatter.parse(dateString)
        val dayOfWeek = c[Calendar.DAY_OF_WEEK]
        return !(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY )

    }

    override fun decorate(view: DayViewFacade?) {
        view!!.setBackgroundDrawable(drawable!!)
    }
}
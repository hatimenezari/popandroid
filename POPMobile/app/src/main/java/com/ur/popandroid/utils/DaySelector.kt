package com.ur.popandroid.utils


import android.app.Activity
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.DayViewDecorator
import com.prolificinteractive.materialcalendarview.DayViewFacade
import com.ur.popandroid.R
import java.util.*


class DaySelector(val context: Activity, val selectedDay: CalendarDay,val type: String) : DayViewDecorator {
    private var drawable: Drawable? = null

    init {
        drawable =  when(type){
            "Vacation" -> ContextCompat.getDrawable(context, R.drawable.leave)
            "Sick" -> ContextCompat.getDrawable(context, R.drawable.sick)
            else -> ContextCompat.getDrawable(context, R.drawable.work)
        }
    }

    override fun shouldDecorate(day: CalendarDay?): Boolean {
        return day!!.equals(selectedDay)

    }

    override fun decorate(view: DayViewFacade?) {
        view!!.setBackgroundDrawable(drawable!!)
    }
}
package com.faraz.materialcalendarview.listeners

import com.faraz.materialcalendarview.EventDay

/**
 * This interface is used to handle long clicks on calendar cells
 *
 * Created by Faraz  Team.
 */

interface OnDayLongClickListener {
    fun onDayLongClick(eventDay: EventDay)
}
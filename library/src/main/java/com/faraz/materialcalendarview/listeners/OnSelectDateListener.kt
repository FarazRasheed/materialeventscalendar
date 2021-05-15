package com.faraz.materialcalendarview.listeners

import java.util.*

/**
 * This interface is used to inform DatePicker that user selected any days
 *
 * Created by Faraz  Team.
 */

interface OnSelectDateListener {

    @JvmSuppressWildcards
    fun onSelect(calendar: List<Calendar>)
}
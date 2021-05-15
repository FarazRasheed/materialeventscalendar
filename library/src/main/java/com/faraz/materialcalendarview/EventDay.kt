package com.faraz.materialcalendarview

import android.graphics.drawable.Drawable
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.RestrictTo
import com.faraz.materialcalendarview.utils.EventImage
import com.faraz.materialcalendarview.utils.setMidnight
import java.util.*

/**
 * This class represents an event of a day. An instance of this class is returned when user click
 * a day cell. This class can be overridden to make calendar more functional. A list of instances of
 * this class can be passed to CalendarView object using setEvents() method.
 *
 *
 * @param calendar      Calendar object which represents a date of the event
 * @param drawable Drawable which will be displayed in a day cell
 * @param drawableRes Drawable resource which will be displayed in a day cell
 * @param labelColor Color which will be displayed as row label text color
 *
 * Created by Faraz  Team.
 */

data class EventDay(val calendar: Calendar) {
    //An object which contains image to display in the day row
    internal var imageDrawable: EventImage = EventImage.EmptyEventImage

    internal var labelColor: Int = 0
    internal var count: String = ""

    @set:RestrictTo(RestrictTo.Scope.LIBRARY)
    var isEnabled: Boolean = false

    init {
        calendar.setMidnight()
    }

    constructor(day: Calendar, drawable: Drawable) : this(day) {
        imageDrawable = EventImage.EventImageDrawable(drawable)
    }

    constructor(day: Calendar, drawable: Drawable, count: String) : this(day) {
        imageDrawable = EventImage.EventImageDrawable(drawable)
        this.count = count
    }

    constructor(day: Calendar, @DrawableRes drawableRes: Int) : this(day) {
        imageDrawable = EventImage.EventImageResource(drawableRes)
    }
    constructor(day: Calendar, @DrawableRes drawableRes: Int, @ColorInt labelColor: Int) : this(day) {
        imageDrawable = EventImage.EventImageResource(drawableRes)
        this.labelColor = labelColor
    }
}
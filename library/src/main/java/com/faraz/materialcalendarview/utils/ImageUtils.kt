@file:JvmName("ImageUtils")

package com.faraz.materialcalendarview.utils

import android.widget.ImageView

/**
 * This class is used to load event image in a day cell
 *
 * Created by Faraz  Team.
 */

internal fun ImageView.loadImage(eventImage: EventImage) {

    when (eventImage) {
        is EventImage.EventImageDrawable -> setImageDrawable(eventImage.drawable)
        is EventImage.EventImageResource -> setImageResource(eventImage.drawableRes)
        is EventImage.EmptyEventImage -> Unit
    }
}

package com.faraz.materialcalendarview.exceptions

/**
 * Created by Faraz  Team.
 */

data class OutOfDateRangeException(override val message: String) : Exception(message)
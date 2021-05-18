package com.faraz.materialeventscalendar.utils;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;

import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;

import com.faraz.materialeventscalendar.R;
import com.faraz.materialcalendarview.CalendarUtils;
import com.faraz.materialcalendarview.utils.DayColorsUtils;

/**
 * Created by Faraz Rasheed on 15.05.2021.
 */

public final class DrawableUtils {
    public static Drawable getCircleDrawableWithText(Context context, String string) {
        Drawable background = ContextCompat.getDrawable(context, R.drawable.sample_circle);
        Drawable text = CalendarUtils.getDrawableText(context, string, null, android.R.color.white, 12);

        Drawable[] layers = {background, text};
        return new LayerDrawable(layers);
    }

    public static Drawable getThreeDots(Context context) {
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.sample_three_icons);

        //Add padding to too large icon
        return new InsetDrawable(drawable, 90, 0, 90, 0);
    }

    public static Drawable getDayCircle(Context context, @ColorRes int borderColor, @ColorRes int fillColor) {
        GradientDrawable drawable = (GradientDrawable) ContextCompat.getDrawable(context, R.drawable.calendar_day_background);
        drawable.setStroke(6, DayColorsUtils.parseColor(context, borderColor));
        drawable.setColor(DayColorsUtils.parseColor(context, fillColor));
        return drawable;
    }

    public static Drawable getSingleEvent(Context context){
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.sample_one_icons);

        //Add padding to too large icon
        return new InsetDrawable(drawable, 100, 0, 100, 0);
    }

    public static Drawable getTwoEvent(Context context){
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.sample_two_icons);

        //Add padding to too large icon
        return new InsetDrawable(drawable, 100, 0, 100, 0);
    }

    public static Drawable getThreeEvent(Context context){
        Drawable drawable = ContextCompat.getDrawable(context, R.drawable.sample_three_icons);

        //Add padding to too large icon
        return new InsetDrawable(drawable, 100, 0, 100, 0);
    }

    private DrawableUtils() {
    }
    public static LayerDrawable showElement(Context context){
        Drawable text = (Drawable) CalendarUtils.getDrawableText(context, "+3", null, android.R.color.holo_red_dark, 15);
        text = new InsetDrawable(text, 100, 0, 100, 0);
        LayerDrawable layers = (LayerDrawable) ContextCompat.getDrawable( context, R.drawable.sample_three_icons); // assuming 'layer-list' is indeed your filename.
        layers.setDrawableByLayerId(R.id.line5, text);

        return layers;
    }
}
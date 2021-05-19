package com.faraz.materialeventscalendar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.faraz.materialeventscalendar.utils.DrawableUtils;
import com.faraz.materialcalendarview.CalendarView;
import com.faraz.materialcalendarview.EventDay;
import com.faraz.materialcalendarview.exceptions.OutOfDateRangeException;
import com.faraz.materialcalendarview.utils.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

/**
 * Created by Faraz Rasheed on 26.04.2021.
 */

public class CalendarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_activity);

        List<EventDay> events = new ArrayList<>();

        // Add 3 plus Events
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 0);
        events.add(new EventDay(calendar, DrawableUtils.getThreeDots(this), "+10"));

        // Add 2 plus Events
        Calendar calendar1 = Calendar.getInstance();
        calendar1.add(Calendar.DAY_OF_MONTH, 1);
        events.add(new EventDay(calendar1, DrawableUtils.getTwoEvent(this)));

        // Add Single Events
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.DAY_OF_MONTH, 2);
        events.add(new EventDay(calendar2, DrawableUtils.getSingleEvent(this)));


        Calendar calendar3 = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 4);
        events.add(new EventDay(calendar3, DrawableUtils.getThreeDots(this), "+10"));
//        Calendar calendar1 = Calendar.getInstance();
//        calendar1.add(Calendar.DAY_OF_MONTH, 4);
//        events.add(new EventDay(calendar1, R.drawable.sample_three_icons));
//
//        Calendar calendar2 = Calendar.getInstance();
//        calendar2.add(Calendar.DAY_OF_MONTH, 10);
//        events.add(new EventDay(calendar2, R.drawable.sample_icon_3, Color.parseColor("#228B22")));
//
//        Calendar calendar3 = Calendar.getInstance();
//        calendar3.add(Calendar.DAY_OF_MONTH, 7);
//        events.add(new EventDay(calendar3, R.drawable.sample_four_icons));
//
//        Calendar calendar4 = Calendar.getInstance();
//        calendar4.add(Calendar.DAY_OF_MONTH, 5);
//        events.add(new EventDay(calendar4, DrawableUtils.getThreeDots(this)));

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);

        Calendar min = Calendar.getInstance();
        min.set(Calendar.DAY_OF_MONTH, 0);

        Calendar max = Calendar.getInstance();
        max.add(Calendar.MONTH, 0);

        calendarView.setMinimumDate(min);
//        calendarView.setMaximumDate(max);

        calendarView.setEvents(events);

//        calendarView.setDisabledDays(getDisabledDays());

        calendarView.setOnDayClickListener(eventDay -> {
                    if(eventDay.isEnabled()){
                        Toast.makeText(getApplicationContext(),
                                eventDay.getCalendar().getTime().toString() + " "
                                        + eventDay.isEnabled(),
                                Toast.LENGTH_SHORT).show();
                    }
        });

        Button setDateButton = (Button) findViewById(R.id.setDateButton);
        setDateButton.setOnClickListener(v -> {
            try {
                Calendar randomCalendar = getRandomCalendar();
                String text = randomCalendar.getTime().toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
                calendarView.setDate(randomCalendar);
            } catch (OutOfDateRangeException exception) {
                exception.printStackTrace();

                Toast.makeText(getApplicationContext(),
                        "Date is out of range",
                        Toast.LENGTH_LONG).show();
            }
        });


    }

    private List<Calendar> getDisabledDays() {
        Calendar firstDisabled = DateUtils.getCalendar();
        firstDisabled.add(Calendar.DAY_OF_MONTH-1, 20);

        Calendar secondDisabled = DateUtils.getCalendar();
        secondDisabled.add(Calendar.DAY_OF_MONTH-1, 21);

        Calendar thirdDisabled = DateUtils.getCalendar();
        thirdDisabled.add(Calendar.DAY_OF_MONTH-1, 22);

        List<Calendar> calendars = new ArrayList<>();
        calendars.add(firstDisabled);
        calendars.add(secondDisabled);
        calendars.add(thirdDisabled);
        return calendars;
    }

    private Calendar getRandomCalendar() {
        Random random = new Random();

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, random.nextInt(99));

        return calendar;
    }


}
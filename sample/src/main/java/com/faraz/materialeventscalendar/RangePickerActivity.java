package com.faraz.materialeventscalendar;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.faraz.materialeventscalendar.utils.DrawableUtils;
import com.faraz.materialcalendarview.CalendarDay;
import com.faraz.materialcalendarview.CalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Mateusz Kornakiewicz on 23.10.2017.
 */

public class RangePickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.range_picker_activity);

        CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
        calendarView.setSelectionBackground(R.drawable.custom_selector);

        CalendarDay calendarDay = new CalendarDay(Calendar.getInstance());
        calendarDay.setBackgroundDrawable(
                DrawableUtils.getDayCircle(getApplicationContext(), R.color.defaultColor, android.R.color.transparent));
        calendarDay.setSelectedBackgroundDrawable(
                DrawableUtils.getDayCircle(getApplicationContext(), R.color.defaultColor, R.color.sampleLight));

        List<CalendarDay> list = new ArrayList<>();
        list.add(calendarDay);

        calendarView.setCalendarDays(list);

        Button getDateButton = (Button) findViewById(R.id.getDateButton);
        getDateButton.setOnClickListener(v -> {
            for (Calendar calendar : calendarView.getSelectedDates()) {
                System.out.println(calendar.getTime().toString());

                Toast.makeText(getApplicationContext(),
                        calendar.getTime().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
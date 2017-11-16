package com.example.schoolsbook.Scheule;

import android.support.annotation.NonNull;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

/**
 * Created by 최민경 on 2017-11-13.
 */

public interface OnDateSelectedListener {

    /**
     * Called when a user clicks on a day.
     * There is no logic to prevent multiple calls for the same date and state.
     *
     * @param widget   the view associated with this listener
     * @param date     the date that was selected or unselected
     * @param selected true if the day is now selected, false otherwise
     */
    void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected);
}

package com.example.schoolsbook.Scheule;

/**
 * Created by 최민경 on 2017-11-13.
 */

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
public interface OnMonthChangedListener {

    /**
     * Called upon change of the selected day
     *
     * @param widget the view associated with this listener
     * @param date   the month picked, as the first day of the month
     */
    void onMonthChanged(MaterialCalendarView widget, CalendarDay date);
}

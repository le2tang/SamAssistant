package com.example.samassistant

import java.util.*

data class ScheduleEntry(
        var name: String, var type: Int = 0,
        var startDatetime: Date? = null, var endDatetime: Date? = null) {
    var start: Calendar;
    var end: Calendar;

    init {
        start = Calendar.getInstance();
        if (startDatetime != null) {
            start.setTime(startDatetime);
        }
        else {
            start.setTime(Date());
        }
        end = Calendar.getInstance();
        if (endDatetime != null) {
            end.setTime(endDatetime);
        }
        else {
            end.setTime(Date());
        }
    }

    fun FormatStartDatetime(): String {
        val currDatetime = Date();
        var startString = "Starts in ";
        if (currDatetime.before(start.getTime())) {
            val diff = start.getTime().time - currDatetime.time;
        }
        else if (currDatetime.after(start.getTime())) {
            val diff = currDatetime.time - start.getTime().time;
        }
        else {

        }
        return startString;
    }
}

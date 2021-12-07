package com.example.samassistant

import java.text.DateFormat
import java.util.*

sealed class ScheduleEntry(var id: String, var name: String, var start: Date) {
    fun formatDiff(diff: Long): String {
        var diffStr: String = "";
        var diffDaysStr: String = "";
        var diffHrsStr: String = "";
        var diffMinsStr: String = "";
        var diffSecsStr: String = "";
        var numFields: Int = 0;

        val diffDays: Long = diff / (1000 * 60 * 60 * 24);
        val diffHrs: Long = diff / (1000 * 60 * 60) - diffDays * 24;
        val diffMins: Long = diff / (1000 * 60) - diffDays * 60 * 24 - diffHrs * 60;
        val diffSecs: Long = diff / 1000 - diffDays * 60 * 60 * 24 - diffHrs * 60 * 60 - diffMins * 60;

        if (diffDays > 1) {
            diffDaysStr = "${diffDays} days";
            ++numFields;
        }
        else if (diffDays.equals(1)) {
            diffDaysStr = "$diffDays} day";
            ++numFields;
        }

        if (diffHrs > 1) {
            diffHrsStr = "${diffHrs} hours";
            ++numFields;
        }
        else if (diffHrs.equals(1)) {
            diffHrsStr = "${diffHrs} hour";
            ++numFields;
        }

        if (diffMins > 1) {
            diffMinsStr = "${diffMins} minutes";
            ++numFields;
        }
        else if (diffMins.equals(1)) {
            diffMinsStr = "${diffMins} minute";
            ++numFields;
        }

        if (diffSecs > 1) {
            diffSecsStr = "${diffSecs} seconds";
            ++numFields;
        }
        else if (diffSecs.equals(1)) {
            diffSecsStr = "${diffSecs} second";
            ++numFields;
        }

        if (diffDaysStr.length > 0) {
            diffStr += diffDaysStr;
            if (numFields > 1) {
                diffStr += ", ";
            }
            --numFields;
        }
        if (diffHrsStr.length > 0) {
            diffStr += diffHrsStr;
            if (numFields > 1) {
                diffStr += ", ";
            }
            --numFields;
        }
        if (diffMinsStr.length > 0) {
            diffStr += diffMinsStr;
            if (numFields > 1) {
                diffStr += ", ";
            }
            --numFields;
        }
        if (diffSecsStr.length > 0) {
            diffStr += diffSecsStr;
        }
        return diffStr;
    }

    fun formatStart(): String {
        val curr: Date = Date();

        var diff: Long = 0;
        if (curr.time < start.time) {
            // Event is upcoming
            diff = start.time - curr.time;
            return "Starts in ${formatDiff(diff)}";
        }
        else {
            // Event has passed
            diff = curr.time - start.time;
            return "Started ${formatDiff(diff)} ago"
        }
    }

    class Meeting(
        id: String,
        name: String,
        var location: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(id, name, start);

    class School(
        id: String,
        name: String,
        var course: String,
        var location: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(id, name, start);

    class Work(
        id: String,
        name: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(id, name, start);

    class Task(
        id: String,
        name: String,
        due: Date
    ) : ScheduleEntry(id, name, due);

    class Due(
        id: String,
        name: String,
        var course: String,
        due: Date
    ) : ScheduleEntry(id, name, due);
}

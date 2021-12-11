package com.example.samassistant

import java.util.*

const val SCHEDULE_ENTRY_ID = "schedule_entry";

sealed class ScheduleEntry(var id: String, var name: String, var start: Date) {
    fun formatDiff(diff: Long): String {
        val diffDays: Long = diff / (1000 * 60 * 60 * 24);
        val diffHrs: Long = diff / (1000 * 60 * 60) - diffDays * 24;
        val diffMins: Long = diff / (1000 * 60) - diffDays * 60 * 24 - diffHrs * 60;

        if (diffDays > 1) {
            return "${diffDays} days";
        }
        else if (diffDays.equals(1)) {
            return "$diffDays} day";
        }
        else if (diffHrs > 1) {
            return "${diffHrs} hours";
        }
        else if (diffHrs.equals(1)) {
            return "${diffHrs} hour";
        }
        else if (diffMins > 1) {
            return "${diffMins} minutes";
        }
        else if (diffMins.equals(1)) {
            return "${diffMins} minute";
        }
        else {
            return "0 minutes";
        }
    }

    open fun formatStart(): String {
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
    ) : ScheduleEntry(id, name, start) {
        fun formatEnd(): String {
            val curr: Date = Date();

            var diff: Long = 0;
            if (curr.time < end.time) {
                // Event is upcoming
                diff = end.time - curr.time;
                return "Ends in ${formatDiff(diff)}";
            }
            else {
                // Event has passed
                diff = curr.time - end.time;
                return "Ended ${formatDiff(diff)} ago"
            }
        }
    }

    class School(
        id: String,
        name: String,
        var course: String,
        var location: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(id, name, start) {
        fun formatEnd(): String {
            val curr: Date = Date();

            var diff: Long = 0;
            if (curr.time < end.time) {
                // Event is upcoming
                diff = end.time - curr.time;
                return "Ends in ${formatDiff(diff)}";
            }
            else {
                // Event has passed
                diff = curr.time - end.time;
                return "Ended ${formatDiff(diff)} ago"
            }
        }
    }

    class Work(
        id: String,
        name: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(id, name, start) {
        fun formatEnd(): String {
            val curr: Date = Date();

            var diff: Long = 0;
            if (curr.time < end.time) {
                // Event is upcoming
                diff = end.time - curr.time;
                return "Ends in ${formatDiff(diff)}";
            }
            else {
                // Event has passed
                diff = curr.time - end.time;
                return "Ended ${formatDiff(diff)} ago"
            }
        }
    }

    class Task(
        id: String,
        name: String,
        due: Date
    ) : ScheduleEntry(id, name, due) {
        override fun formatStart(): String {
            val curr: Date = Date();

            var diff: Long = 0;
            if (curr.time < start.time) {
                // Event is upcoming
                diff = start.time - curr.time;
                return "Due in ${formatDiff(diff)}";
            }
            else {
                // Event has passed
                diff = curr.time - start.time;
                return "Due ${formatDiff(diff)} ago"
            }
        }
    }

    class Due(
        id: String,
        name: String,
        var course: String,
        due: Date
    ) : ScheduleEntry(id, name, due) {
        override fun formatStart(): String {
            val curr: Date = Date();

            var diff: Long = 0;
            if (curr.time < start.time) {
                // Event is upcoming
                diff = start.time - curr.time;
                return "Due in ${formatDiff(diff)}";
            }
            else {
                // Event has passed
                diff = curr.time - start.time;
                return "Due ${formatDiff(diff)} ago"
            }
        }
    }
}

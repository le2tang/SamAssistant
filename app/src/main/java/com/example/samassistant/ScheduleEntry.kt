package com.example.samassistant

import java.util.*

const val SCHEDULE_ENTRY_ID = "schedule_entry";

const val SCHEDULE_ENTRY_TYPE_ENTRY = 0;
const val SCHEDULE_ENTRY_TYPE_MEETING = 1;
const val SCHEDULE_ENTRY_TYPE_SCHOOL = 2;
const val SCHEDULE_ENTRY_TYPE_WORK = 3;
const val SCHEDULE_ENTRY_TYPE_TASK = 4;
const val SCHEDULE_ENTRY_TYPE_DUE = 5;

sealed class ScheduleEntry(var name: String, var start: Date) {
    var uuid: UUID = UUID.randomUUID();
    open val type = SCHEDULE_ENTRY_TYPE_ENTRY;

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
        name: String,
        var location: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(name, start) {
        override val type = SCHEDULE_ENTRY_TYPE_MEETING;

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
        name: String,
        var course: String,
        var location: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(name, start) {
        override val type = SCHEDULE_ENTRY_TYPE_SCHOOL;

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
        name: String,
        start: Date,
        var end: Date
    ) : ScheduleEntry(name, start) {
        override val type = SCHEDULE_ENTRY_TYPE_WORK;

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
        name: String,
        due: Date
    ) : ScheduleEntry(name, due) {
        override val type = SCHEDULE_ENTRY_TYPE_TASK;

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
        name: String,
        var course: String,
        due: Date
    ) : ScheduleEntry(name, due) {
        override val type = SCHEDULE_ENTRY_TYPE_DUE;

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

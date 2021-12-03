package com.example.samassistant

import java.util.*

sealed class ScheduleEntry(var id: String, var name: String) {
    class Meeting(
        id: String,
        name: String,
        var location: String,
        var start: Date = Date(),
        var end: Date = Date()
    ) : ScheduleEntry(id, name);

    class School(
        id: String,
        name: String,
        var course: String,
        var location: String,
        var start: Date = Date(),
        var end: Date = Date()
    ) : ScheduleEntry(id, name);

    class Work(
        id: String,
        name: String,
        var start: Date = Date(),
        var end: Date = Date()
    ) : ScheduleEntry(id, name);

    class Task(
        id: String,
        name: String,
        var due: Date = Date()
    ) : ScheduleEntry(id, name)

    class Due(
        id: String,
        name: String,
        var course: String,
        var due: Date = Date()
    ) : ScheduleEntry(id, name);
}

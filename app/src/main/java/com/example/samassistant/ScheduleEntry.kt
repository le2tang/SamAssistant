package com.example.samassistant

import java.util.*

data class ScheduleEntry(var name: String, var type: Int = 0) {
    var startDatetime: Date = Date();
    var endDatetime: Date = Date();
}

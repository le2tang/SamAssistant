package com.example.samassistant

import android.icu.util.DateInterval

open class ScheduleBlock : ScheduleBase {
    var interval: DateInterval = DateInterval(0, 0);
    var priority: Int = 0;

    constructor(block_name: String, block_interval: DateInterval, block_priority: Int) : super(block_name) {
        interval = block_interval;
        priority = block_priority;
    }

    fun Intersects(other: ScheduleBlock): Boolean {
        return (interval.fromDate <= other.interval.toDate &&
                interval.toDate >= other.interval.fromDate);
    }
}
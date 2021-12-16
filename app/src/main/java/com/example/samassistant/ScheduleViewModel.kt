package com.example.samassistant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ScheduleViewModel() : ViewModel() {
    var selected = MutableLiveData<Int>(0);
    var entries = MutableLiveData<List<ScheduleEntry>>(
        listOf<ScheduleEntry>(
            ScheduleEntry.Meeting(
                "Meeting",
                "Location",
                Date(2021 - 1900, 11, 19, 9, 30, 0),
                Date(2021 - 1900, 11, 19, 10, 0, 0)
            ),
            ScheduleEntry.School(
                "School",
                "Course",
                "Location",
                Date(2021 - 1900, 11, 19, 9, 30, 0),
                Date(2021 - 1900, 11, 19, 10, 0, 0)
            ),
            ScheduleEntry.Work(
                "Work",
                Date(2021 - 1900, 11, 19, 9, 30, 0),
                Date(2021 - 1900, 11, 19, 10, 0, 0)
            ),
            ScheduleEntry.Task(
                "Task",
                Date(2021 - 1900, 11, 19, 9, 30, 0)
            ),
            ScheduleEntry.Due(
                "Due",
                "Course",
                Date(2021 - 1900, 11, 7, 20, 50, 0)
            )
        )
    );

    fun setSelected(position: Int) {
        selected.value = position;
    }

    fun getSelected(): LiveData<Int> {
        return selected;
    }

    fun getEntries(): LiveData<List<ScheduleEntry>> {
        return entries;
    }
}

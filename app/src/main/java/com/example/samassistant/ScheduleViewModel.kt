package com.example.samassistant

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class ScheduleViewModel(repository: ScheduleRepository) : ViewModel() {
    var entries = MutableLiveData<List<ScheduleEntry>>();
    var selected = 0;
}

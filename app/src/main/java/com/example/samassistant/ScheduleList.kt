package com.example.samassistant

class ScheduleList : ScheduleBase {
    var list = mutableListOf<ScheduleBase>();
    var map = mutableMapOf<String, ScheduleBase>();

    constructor(list_name: String) : super(list_name) {

    }

    fun add(entry: ScheduleBase) {
        list.add(entry);
        map[entry.name] = list.last();
    }
}
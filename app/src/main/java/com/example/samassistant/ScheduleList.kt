package com.example.samassistant

var scheduleEntries = mutableListOf<ScheduleEntry>();

class ScheduleList : ScheduleEntry {
    var list = mutableListOf<ScheduleEntry>();
    var map = mutableMapOf<String, ScheduleEntry>();

    constructor(listName: String) : super(listName) {

    }

    fun add(entry: ScheduleEntry) {
        list.add(entry);
        map[entry.name] = list.last();
    }
}
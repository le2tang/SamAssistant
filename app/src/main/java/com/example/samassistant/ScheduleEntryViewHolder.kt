package com.example.samassistant

import androidx.recyclerview.widget.RecyclerView
import com.example.samassistant.databinding.ScheduleEntryBinding

class ScheduleEntryViewHolder(
    private val scheduleEntryBinding: ScheduleEntryBinding,
    private val clickListener: ScheduleEntryClickListener
    )
    : RecyclerView.ViewHolder(scheduleEntryBinding.root) {
        fun bindScheduleEntry(entry: ScheduleEntry) {
            scheduleEntryBinding.entryName.text = "Hello World";

            scheduleEntryBinding.entry.setOnClickListener {
                clickListener.onClick(entry)
            };
    }
}
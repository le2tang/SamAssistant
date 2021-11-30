package com.example.samassistant

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.samassistant.databinding.ScheduleEntryBinding

class ScheduleEntryAdapter(
    private val entries: List<ScheduleEntry>,
    private val clickListener: ScheduleEntryClickListener
    )
    : RecyclerView.Adapter<ScheduleEntryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, view_type: Int) : ScheduleEntryViewHolder {
        val from = LayoutInflater.from(parent.context);
        val binding = ScheduleEntryBinding.inflate(from, parent, false);
        return ScheduleEntryViewHolder(binding, clickListener);
    }

    override fun onBindViewHolder(holder: ScheduleEntryViewHolder, position: Int) {
        holder.bindScheduleEntry(entries[position]);
    }

    override fun getItemCount(): Int {
        return entries.size;
    }
}
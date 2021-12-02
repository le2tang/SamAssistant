package com.example.samassistant

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ScheduleAdapter(private var entries: List<ScheduleEntry>) :
    RecyclerView.Adapter<ScheduleAdapter.ViewHolder>() {

    class ViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {
        val entry: LinearLayout;
        val entryName: TextView;
        val entryType: TextView;
        init {
            entry = view.findViewById(R.id.entry);
            entryName = view.findViewById(R.id.entryName);
            entryType = view.findViewById(R.id.entryType);
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.schedule_entry, viewGroup, false);
        return ViewHolder(view);
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.entry.setOnClickListener {
            Toast.makeText(viewHolder.entry.context,
                "Clicked position $position", Toast.LENGTH_SHORT).show()
            entries[position].type += 1;
            viewHolder.entryType.text = entries[position].type.toString();
        };
        viewHolder.entryName.text = entries[position].name
        viewHolder.entryType.text = entries[position].type.toString();
    }

    override fun getItemCount(): Int {
        return entries.size;
    }
}
package com.example.samassistant

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samassistant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    var scheduleEntries: MutableList<ScheduleEntry> = mutableListOf<ScheduleEntry>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        scheduleEntries.add(ScheduleEntry.Meeting("meeting0", "Meeting", "Location"));
        scheduleEntries.add(ScheduleEntry.School("school0", "School", "Course", "Location"));
        scheduleEntries.add(ScheduleEntry.Work("work0", "Work"));
        scheduleEntries.add(ScheduleEntry.Task("task0", "Task"));
        scheduleEntries.add(ScheduleEntry.Due("due0", "Due", "Course"));

        binding.recyclerView.adapter = ScheduleAdapter(scheduleEntries);
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false);

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, CreateNewEntry::class.java);

            scheduleEntries.add(ScheduleEntry.Meeting(
                "meeting" + scheduleEntries.size.toString(),
                "Meeting",
                "Location"
            ));

            startActivity(intent);
        };
    }
}
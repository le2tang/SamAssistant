package com.example.samassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samassistant.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    private var scheduleEntries: MutableList<ScheduleEntry> = mutableListOf<ScheduleEntry>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        scheduleEntries.add(
            ScheduleEntry.Meeting(
                "meeting0",
                "Meeting",
                "Location",
                Date(2021-1900, 11, 19, 9, 30, 0),
                Date(2021-1900, 11, 19, 10, 0, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.School(
                "school0",
                "School",
                "Course",
                "Location",
                Date(2021-1900, 11, 19, 9, 30, 0),
                Date(2021-1900, 11, 19, 10, 0, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.Work(
                "work0",
                "Work",
                Date(2021-1900, 11, 19, 9, 30, 0),
                Date(2021-1900, 11, 19, 10, 0, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.Task(
                "task0",
                "Task",
                Date(2021-1900, 11, 19, 9, 30, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.Due(
                "due0",
                "Due",
                "Course",
                Date(2021-1900, 11, 19, 9, 30, 0)
            )
        );

        binding.recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false);
        binding.recyclerView.adapter = ScheduleAdapter(scheduleEntries);

        binding.createButton.setOnClickListener {
            val intent = Intent(this, CreateEntryActivity::class.java);
            startActivity(intent);
        }
    }
}
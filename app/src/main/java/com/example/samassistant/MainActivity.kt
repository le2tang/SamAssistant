package com.example.samassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samassistant.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;

    private var scheduleEntries: MutableList<ScheduleEntry> = mutableListOf<ScheduleEntry>();
    private val model: ScheduleViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        scheduleEntries.add(
            ScheduleEntry.Meeting(
                "Meeting",
                "Location",
                Date(2021 - 1900, 11, 19, 9, 30, 0),
                Date(2021 - 1900, 11, 19, 10, 0, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.School(
                "School",
                "Course",
                "Location",
                Date(2021 - 1900, 11, 19, 9, 30, 0),
                Date(2021 - 1900, 11, 19, 10, 0, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.Work(
                "Work",
                Date(2021 - 1900, 11, 19, 9, 30, 0),
                Date(2021 - 1900, 11, 19, 10, 0, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.Task(
                "Task",
                Date(2021 - 1900, 11, 19, 9, 30, 0)
            )
        );
        scheduleEntries.add(
            ScheduleEntry.Due(
                "Due",
                "Course",
                Date(2021 - 1900, 11, 7, 20, 50, 0)
            )
        );

        binding.recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        );
        binding.recyclerView.adapter = ScheduleAdapter(scheduleEntries);

        binding.createButton.setOnClickListener {
            val intent = Intent(this, CreateEntryActivity::class.java);
            startActivity(intent);
        }
    }
}
package com.example.samassistant

import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samassistant.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ScheduleEntryClickListener {
    private lateinit var binding: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        scheduleEntries.add(ScheduleEvent("evt0"));
        scheduleEntries.add(ScheduleEvent("evt1"));
        scheduleEntries.add(ScheduleEvent("evt2"));
        scheduleEntries.add(ScheduleEvent("evt3"));
        scheduleEntries.add(ScheduleEvent("evt4"));
        scheduleEntries.add(ScheduleEvent("evt5"));

        val mainActivity = this;

        // Set the attributes of the element with id=recyclerView
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
            adapter = ScheduleEntryAdapter(scheduleEntries, mainActivity)
        };

        binding.addEntry.setOnClickListener {
            Toast.makeText(applicationContext, "Add entry", Toast.LENGTH_SHORT).show();
        }
    }

    override fun onClick(entry: ScheduleEntry) {
        val intent = Intent(applicationContext, ScheduleBlockDetailActivity::class.java);
        intent.putExtra(SCHEDULE_ENTRY_EXTRA, entry.name);
        startActivity(intent);

        Toast.makeText(applicationContext, "This is a toast", Toast.LENGTH_SHORT).show();
    }
}
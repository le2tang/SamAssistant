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

        scheduleEntries.add(ScheduleEntry("entry0"));
        scheduleEntries.add(ScheduleEntry("entry1"));
        scheduleEntries.add(ScheduleEntry("entry2"));
        scheduleEntries.add(ScheduleEntry("entry3"));
        scheduleEntries.add(ScheduleEntry("entry4"));

        binding.recyclerView.adapter = ScheduleAdapter(scheduleEntries);
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false);

        binding.floatingActionButton.setOnClickListener {
            val intent = Intent(this, CreateNewEntry::class.java);

            scheduleEntries.add(ScheduleEntry("entry" + scheduleEntries.size.toString()));

            startActivity(intent);
        };
    }
}
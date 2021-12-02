package com.example.samassistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
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

        binding.recyclerView.adapter = ScheduleAdapter(scheduleEntries);
        binding.recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false);
    }
}
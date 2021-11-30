package com.example.samassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.samassistant.databinding.ActivityScheduleBlockDetailBinding

class ScheduleBlockDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityScheduleBlockDetailBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        binding = ActivityScheduleBlockDetailBinding.inflate(layoutInflater);
        setContentView(binding.root);

        val entryName = intent.getStringExtra(SCHEDULE_ENTRY_EXTRA);
        if (entryName != null) {
            val entry = findEntry(entryName);
            if (entry != null) {
                binding.entryName.text = entry.name;
            }
        }
    }

    private fun findEntry(entryName: String): ScheduleEntry? {
        for (entry in scheduleEntries) {
            if (entryName == entry.name) {
                return entry;
            }
        }
        return null;
    }
}
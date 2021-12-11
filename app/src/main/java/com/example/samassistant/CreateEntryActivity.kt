package com.example.samassistant

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.get
import com.example.samassistant.databinding.*
import com.google.android.material.tabs.TabLayout
import java.util.*

class CreateEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateEntryBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateEntryBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.viewPager.adapter = CreateEntryAdapter(
            supportFragmentManager,
            this
        );

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewPager.currentItem = tab.position
                };
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        });
        binding.tabLayout.setupWithViewPager(binding.viewPager);

        binding.saveBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

        binding.cancelBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }

    private fun saveEntry() {
        val resultIntent = Intent();

        val position = binding.tabLayout.selectedTabPosition;
        if (position == 0) {
            val meetingBinding = (binding.viewPager[position] as ScheduleMeetingBinding);

            val entry = ScheduleEntry.Meeting(
                meetingBinding.name.text.toString(),
                meetingBinding.name.text.toString(),
                meetingBinding.location.text.toString(),
                Date(meetingBinding.start.text.toString()),
                Date(meetingBinding.end.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else if (position == 1) {
            val schoolBinding = (binding.viewPager[position] as ScheduleSchoolBinding);

            val entry = ScheduleEntry.School(
                schoolBinding.name.text.toString(),
                schoolBinding.name.text.toString(),
                schoolBinding.course.text.toString(),
                schoolBinding.location.text.toString(),
                Date(schoolBinding.start.text.toString()),
                Date(schoolBinding.end.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else if (position == 2) {
            val workBinding= (binding.viewPager[position] as ScheduleWorkBinding);

            val entry = ScheduleEntry.Work(
                workBinding.name.text.toString(),
                workBinding.name.text.toString(),
                Date(workBinding.start.text.toString()),
                Date(workBinding.end.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else if (position == 3) {
            val taskBinding = (binding.viewPager[position] as ScheduleTaskBinding);

            val entry = ScheduleEntry.Task(
                taskBinding.name.text.toString(),
                taskBinding.name.text.toString(),
                Date(taskBinding.start.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else if (position == 4) {
            val dueBinding = (binding.viewPager[position] as ScheduleDueBinding);

            val entry = ScheduleEntry.Due(
                dueBinding.name.text.toString(),
                dueBinding.name.text.toString(),
                dueBinding.course.text.toString(),
                Date(dueBinding.start.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else {
            throw IllegalAccessError("Invalid tab layout position");
        }
        finish();
    }
}
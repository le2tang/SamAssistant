package com.example.samassistant

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.samassistant.databinding.*
import com.google.android.material.tabs.TabLayout
import java.util.*

class CreateEntryActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    private lateinit var binding: ActivityCreateEntryBinding;

    var year: Int = 0;
    var month: Int = 0;
    var date: Int = 0;
    var hour: Int = 0;
    var min: Int = 0;

    private lateinit var model: ScheduleViewModel;

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
            val cal = Calendar.getInstance();
            year = cal.get(Calendar.YEAR);
            month = cal.get(Calendar.MONTH);
            date = cal.get(Calendar.DATE);
            hour = cal.get(Calendar.HOUR);
            min = cal.get(Calendar.MINUTE);
            val dpDialog = DatePickerDialog(this, this, year, month, date).show();

//            val intent = Intent(this, MainActivity::class.java);
//            startActivity(intent);
        }

        binding.cancelBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(applicationContext, "Saved $year-$month-$dayOfMonth", Toast.LENGTH_SHORT).show()
        TimePickerDialog(this, this, hour, min, false).show();
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(applicationContext, "Saved $hourOfDay-$minute", Toast.LENGTH_SHORT).show()
    }

    private fun saveEntry() {
        val resultIntent = Intent();

        val position = binding.tabLayout.selectedTabPosition;
        if (position == 0) {


            setResult(Activity.RESULT_OK, resultIntent);
        }
        else if (position == 1) {
            val schoolBinding = (binding.viewPager[position] as ScheduleSchoolBinding);

            val entry = ScheduleEntry.School(
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
                Date(workBinding.start.text.toString()),
                Date(workBinding.end.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else if (position == 3) {
            val taskBinding = (binding.viewPager[position] as ScheduleTaskBinding);

            val entry = ScheduleEntry.Task(
                taskBinding.name.text.toString(),
                Date(taskBinding.start.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else if (position == 4) {
            val dueBinding = (binding.viewPager[position] as ScheduleDueBinding);

            val entry = ScheduleEntry.Due(
                dueBinding.name.text.toString(),
                dueBinding.course.text.toString(),
                Date(dueBinding.start.text.toString())
            );

            setResult(Activity.RESULT_OK, resultIntent);
        }
        else {
            throw IllegalAccessError("Invalid tab layout position");
        }

        resultIntent.putExtra(SCHEDULE_ENTRY_ID, "Hello world");

        finish();
    }
}
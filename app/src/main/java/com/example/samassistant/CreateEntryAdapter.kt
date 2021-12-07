package com.example.samassistant

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import java.lang.IllegalArgumentException

class CreateEntryAdapter(fm: FragmentManager, private val context: Context)
        : FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        if (position == 0) {
            return CreateScheduleMeeting();
        }
        else if (position == 1) {
            return CreateScheduleSchool();
        }
        else if (position == 2) {
            return CreateScheduleWork();
        }
        else if (position == 3) {
            return CreateScheduleTask();
        }
        else if (position == 4) {
            return CreateScheduleDue();
        }
        else {
            throw IllegalArgumentException("Invalid tab position");
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0) {
            return context.getString(R.string.meeting);
        }
        else if (position == 1) {
            return context.getString(R.string.school);
        }
        else if (position == 2) {
            return context.getString(R.string.work);
        }
        else if (position == 3) {
            return context.getString(R.string.task);
        }
        else if (position == 4) {
            return context.getString(R.string.due);
        }
        else {
            throw IllegalArgumentException("Invalid tab position");
        }
    }

    override fun getCount(): Int {
        return 5;
    }
}

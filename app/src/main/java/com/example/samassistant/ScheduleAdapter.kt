package com.example.samassistant

import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.samassistant.databinding.*
import java.lang.IllegalArgumentException

class ScheduleAdapter(scheduleEntries: MutableList<ScheduleEntry>)
        : RecyclerView.Adapter<ScheduleAdapter.ScheduleEntryViewHolder>() {

    var entries = scheduleEntries
        set(value) {
            field = value;
            notifyDataSetChanged();
        };

    sealed class ScheduleEntryViewHolder(binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        class MeetingViewHolder(private val binding: ScheduleMeetingBinding)
                : ScheduleEntryViewHolder(binding) {
            fun bind(meeting: ScheduleEntry.Meeting) {
                binding.name.text = meeting.name;
                binding.location.text = meeting.location;
                binding.start.text = meeting.formatStart();
                binding.end.text = meeting.formatEnd();

                binding.delete.setOnClickListener(object : View.OnClickListener {
                   override fun onClick(view: View) {
                       Toast.makeText(view.context, "Delete", Toast.LENGTH_SHORT).show()
                   }
                });

                binding.meeting.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View) {
                        Toast.makeText(view.context, meeting.name, Toast.LENGTH_SHORT).show()
                    }
                });
            }
        }

        class SchoolViewHolder(private val binding: ScheduleSchoolBinding)
                : ScheduleEntryViewHolder(binding) {
            fun bind(school: ScheduleEntry.School) {
                binding.name.text = school.name;
                binding.course.text = school.course;
                binding.location.text = school.location;
                binding.start.text = school.formatStart();
                binding.end.text = school.formatEnd();

                binding.school.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View) {
                        Toast.makeText(view.context, school.name, Toast.LENGTH_SHORT).show()
                    }
                });
            }
        }

        class WorkViewHolder(private val binding: ScheduleWorkBinding)
                : ScheduleEntryViewHolder(binding) {
            fun bind(work: ScheduleEntry.Work) {
                binding.name.text = work.name;
                binding.start.text = work.formatStart();
                binding.end.text = work.formatEnd();

                binding.work.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View) {
                        Toast.makeText(view.context, work.name, Toast.LENGTH_SHORT).show()
                    }
                });
            }
        }

        class TaskViewHolder(private val binding: ScheduleTaskBinding)
                : ScheduleEntryViewHolder(binding) {
            fun bind(task: ScheduleEntry.Task) {
                binding.name.text = task.name;
                binding.start.text = task.formatStart();

                binding.task.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View) {
                        Toast.makeText(view.context, task.name, Toast.LENGTH_SHORT).show()
                    }
                });
            }
        }

        class DueViewHolder(private val binding: ScheduleDueBinding)
                : ScheduleEntryViewHolder(binding) {
            fun bind(due: ScheduleEntry.Due) {
                binding.name.text = due.name;
                binding.start.text = due.formatStart();

                binding.due.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(view: View) {
                        Toast.makeText(view.context, due.name, Toast.LENGTH_SHORT).show()
                    }
                });
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleEntryViewHolder {
        if (viewType == R.layout.schedule_meeting) {
            return ScheduleEntryViewHolder.MeetingViewHolder(
                ScheduleMeetingBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            );
        }
        else if (viewType == R.layout.schedule_school) {
            return ScheduleEntryViewHolder.SchoolViewHolder(
                ScheduleSchoolBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            );
        }
        else if (viewType == R.layout.schedule_work) {
            return ScheduleEntryViewHolder.WorkViewHolder(
                ScheduleWorkBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            );
        }
        else if (viewType == R.layout.schedule_task) {
            return ScheduleEntryViewHolder.TaskViewHolder(
                ScheduleTaskBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            );
        }
        else if (viewType == R.layout.schedule_due) {
            return ScheduleEntryViewHolder.DueViewHolder(
                ScheduleDueBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            );
        }
        else {
            throw IllegalArgumentException("Invalid view type");
        }
    }

    override fun onBindViewHolder(viewHolder: ScheduleEntryViewHolder, position: Int) {
        if (viewHolder is ScheduleEntryViewHolder.MeetingViewHolder) {
            return viewHolder.bind(entries[position] as ScheduleEntry.Meeting);
        }
        else if (viewHolder is ScheduleEntryViewHolder.SchoolViewHolder) {
            return viewHolder.bind(entries[position] as ScheduleEntry.School)
        }
        else if (viewHolder is ScheduleEntryViewHolder.WorkViewHolder) {
            return viewHolder.bind(entries[position] as ScheduleEntry.Work);
        }
        else if (viewHolder is ScheduleEntryViewHolder.TaskViewHolder) {
            return viewHolder.bind(entries[position] as ScheduleEntry.Task)
        }
        else if (viewHolder is ScheduleEntryViewHolder.DueViewHolder) {
            return viewHolder.bind(entries[position] as ScheduleEntry.Due)
        }
        else {
            throw IllegalArgumentException("Invalid view holder");
        }
    }

    override fun getItemCount(): Int {
        return entries.size;
    }

    override fun getItemViewType(position: Int): Int {
        if (entries[position] is ScheduleEntry.Meeting) {
            return R.layout.schedule_meeting;
        }
        else if (entries[position] is ScheduleEntry.School) {
            return R.layout.schedule_school;
        }
        else if (entries[position] is ScheduleEntry.Work) {
            return R.layout.schedule_work;
        }
        else if (entries[position] is ScheduleEntry.Task) {
            return R.layout.schedule_task;
        }
        else if (entries[position] is ScheduleEntry.Due) {
            return R.layout.schedule_due;
        }
        else {
            throw IllegalArgumentException("Invalid entry type");
        }
    }
}
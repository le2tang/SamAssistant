package com.example.samassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.commit
import com.example.samassistant.databinding.ActivityEditEntryBinding
import java.lang.IllegalStateException

const val EDIT_ENTRY_POSITION = "EDIT_ENTRY_POSITION";

class EditEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditEntryBinding;
    private val model: ScheduleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityEditEntryBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.saveBtn.setOnClickListener {
            Toast.makeText(binding.saveBtn.context, "Save", Toast.LENGTH_SHORT).show()

            (if (model.getSelected().value!! < 4) model.getSelected().value?.plus(1) else 0)?.let { it1 ->
                model.setSelected(
                    it1
                )
            };
        };

        binding.cancelBtn.setOnClickListener {
            Toast.makeText(binding.cancelBtn.context, "Cancel", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        };

        if (savedInstanceState == null) {
            val position = intent.getIntExtra(EDIT_ENTRY_POSITION, 0);
            val entry = model.getEntry(position);

            Log.println(Log.DEBUG, "Position", position.toString())

            if (entry?.type == SCHEDULE_ENTRY_TYPE_MEETING) {
                val fragment = EditMeetingFragment.newInstance(position);
                supportFragmentManager.commit {
                    setReorderingAllowed(true);
                    add(binding.editEntryFragmentFrame.id, fragment);
                }
            }
            else if (entry?.type == SCHEDULE_ENTRY_TYPE_SCHOOL) {
                val fragment = EditSchoolFragment.newInstance(position);
                supportFragmentManager.commit {
                    setReorderingAllowed(true);
                    add(binding.editEntryFragmentFrame.id, fragment);
                }
            }
            else if (entry?.type == SCHEDULE_ENTRY_TYPE_WORK) {
                val fragment = EditWorkFragment.newInstance(position);
                supportFragmentManager.commit {
                    setReorderingAllowed(true);
                    add(binding.editEntryFragmentFrame.id, fragment);
                }
            }
            else if (entry?.type == SCHEDULE_ENTRY_TYPE_TASK) {
                val fragment = EditTaskFragment.newInstance(position);
                supportFragmentManager.commit {
                    setReorderingAllowed(true);
                    add(binding.editEntryFragmentFrame.id, fragment);
                }
            }
            else if (entry?.type == SCHEDULE_ENTRY_TYPE_DUE) {
                val fragment = EditDueFragment.newInstance(position);
                supportFragmentManager.commit {
                    setReorderingAllowed(true);
                    add(binding.editEntryFragmentFrame.id, fragment);
                }
            }
            else {
                throw IllegalStateException("Invalid entry type");
            }
        }
    }
}
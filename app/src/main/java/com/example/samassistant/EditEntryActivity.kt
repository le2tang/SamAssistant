package com.example.samassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.Observer
import com.example.samassistant.databinding.ActivityEditEntryBinding
import com.example.samassistant.databinding.FragmentCreateScheduleMeetingBinding
import com.example.samassistant.databinding.FragmentCreateScheduleSchoolBinding
import java.lang.Integer.parseInt

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

        model.selected.observe(this, Observer<Int> {
            position -> binding.editEntryName.text = position.toString();
        })

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true);
                add<EditMeetingFragment>(binding.editEntryFragmentFrame.id);
            }
        }
    }
}
package com.example.samassistant

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.samassistant.databinding.FragmentEditTaskBinding

private const val ARG_PARAM0 = "POSITION";

class EditTaskFragment() : Fragment() {
    private lateinit var binding: FragmentEditTaskBinding;
    private val model: ScheduleViewModel by activityViewModels();
    private var position: Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(ARG_PARAM0)
        };
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditTaskBinding.inflate(layoutInflater);

        Log.println(Log.DEBUG, "Position", "EditTaskFragment: $position");

        val entry = model.getEntry(position) as ScheduleEntry.Task;
        binding.name.text = entry.name;
        binding.start.text = entry.formatStart();

        return binding.root;
    }

    companion object {
        @JvmStatic
        fun newInstance(position: Int) =
            EditTaskFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM0, position)
                }
            }
    }
}
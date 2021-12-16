package com.example.samassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.samassistant.databinding.FragmentEditMeetingBinding
import java.lang.Integer.parseInt
import kotlin.math.absoluteValue

private const val ARG_PARAM0 = "POSITION";

class EditMeetingFragment : Fragment() {
    private lateinit var binding: FragmentEditMeetingBinding;
    private val model: ScheduleViewModel by activityViewModels();

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEditMeetingBinding.inflate(layoutInflater);

        model.selected.observe(viewLifecycleOwner, Observer<Int> { position ->
            binding.name.text = model.getEntries().value?.get(position)?.name ?: "No name";
        })

        return binding.root;
    }

    companion object {
        @JvmStatic
        fun newInstance(position: String) {
            EditMeetingFragment().apply {
                arguments?.apply {
                    putInt(ARG_PARAM0, parseInt(position));
                }
            }
        }
    }
}
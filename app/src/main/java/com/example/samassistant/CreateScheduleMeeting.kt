package com.example.samassistant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.samassistant.databinding.FragmentCreateScheduleMeetingBinding
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM0 = "uuid"
private const val ARG_PARAM1 = "name"
private const val ARG_PARAM2 = "location"
private const val ARG_PARAM3 = "start"
private const val ARG_PARAM4 = "end"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateScheduleMeeting.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateScheduleMeeting : Fragment() {
    private lateinit var binding: FragmentCreateScheduleMeetingBinding;

    private var entry: ScheduleEntry.Meeting? = null;

    private val model: ScheduleViewModel by activityViewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            entry?.uuid = UUID.fromString(it.getString(ARG_PARAM0))
            entry?.name = it.getString(ARG_PARAM1).toString()
            entry?.location = it.getString(ARG_PARAM2).toString()
            entry?.start = Date(it.getString(ARG_PARAM3))
            entry?.end = Date(it.getString(ARG_PARAM4))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateScheduleMeetingBinding.inflate(layoutInflater);

        return binding.root;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreateScheduleMeeting.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateScheduleMeeting().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
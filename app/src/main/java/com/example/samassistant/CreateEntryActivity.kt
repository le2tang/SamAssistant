package com.example.samassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.samassistant.databinding.ActivityCreateEntryBinding

class CreateEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateEntryBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateEntryBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.saveBtn.setOnClickListener {}
        binding.cancelBtn.setOnClickListener {}
    }
}
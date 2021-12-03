package com.example.samassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.samassistant.databinding.ActivityCreateNewEntryBinding

class CreateNewEntry : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNewEntryBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateNewEntryBinding.inflate(layoutInflater);
        setContentView(binding.root);
    }
}
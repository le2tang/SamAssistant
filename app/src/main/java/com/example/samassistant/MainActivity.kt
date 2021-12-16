package com.example.samassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.samassistant.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    private val model: ScheduleViewModel by viewModels();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.recyclerView.layoutManager = LinearLayoutManager(
            this, LinearLayoutManager.VERTICAL, false
        );
        binding.recyclerView.adapter = ScheduleAdapter(model.getEntries().value);

        binding.createButton.setOnClickListener {
            val intent = Intent(this, CreateEntryActivity::class.java);
            startActivity(intent);
        }
    }
}
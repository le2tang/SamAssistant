package com.example.samassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.samassistant.databinding.ActivityCreateEntryBinding

class CreateEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateEntryBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        binding = ActivityCreateEntryBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.saveBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }

        binding.cancelBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        }
    }
}
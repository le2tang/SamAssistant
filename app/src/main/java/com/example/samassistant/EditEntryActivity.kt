package com.example.samassistant

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.samassistant.databinding.ActivityEditEntryBinding

class EditEntryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditEntryBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEditEntryBinding.inflate(layoutInflater);
        setContentView(binding.root);

        binding.saveBtn.setOnClickListener {
            Toast.makeText(binding.saveBtn.context, "Save", Toast.LENGTH_SHORT).show()
        };

        binding.cancelBtn.setOnClickListener {
            Toast.makeText(binding.cancelBtn.context, "Cancel", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent);
        };
    }
}
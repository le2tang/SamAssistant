package com.example.samassistant

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.samassistant.databinding.ActivityCreateNewEntryBinding

class CreateNewEntry : AppCompatActivity() {
    private lateinit var binding: ActivityCreateNewEntryBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_entry)


    }
}
package com.example.techconference2025

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.techconference2025.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupSpeakersList()
        setupExpandableSchedule()
    }

    private fun setupSpeakersList() {
        val speakers = listOf(
            Speaker("Dr. Emily Chen", "AI Researcher"),
            Speaker("Jake Wharton", "Android GDE"),
            Speaker("Sarah Connor", "Security Expert")
        )

        binding.rvSpeakers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.rvSpeakers.adapter = SpeakerAdapter(speakers)
    }

    private fun setupExpandableSchedule() {
        var expanded = false

        binding.tvScheduleExpand.setOnClickListener {
            expanded = !expanded

            if (expanded) {
                binding.tvScheduleExpand.text = "Hide Details ▲"
                binding.tvScheduleDetails.visibility = View.VISIBLE
            } else {
                binding.tvScheduleExpand.text = "View Details ▼"
                binding.tvScheduleDetails.visibility = View.GONE
            }
        }
    }
}

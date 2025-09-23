package com.acrossdeiiglobe.recordapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.acrossdeiglobe.recordapp.R
import com.acrossdeiglobe.recordapp.databinding.ActivityEditRunningRecordBinding
import com.acrossdeiglobe.recordapp.databinding.FragmentCyclingBinding
import kotlin.jvm.java
import kotlin.properties.ReadWriteProperty

class CyclingFragment : Fragment () {

    private lateinit var binding: FragmentCyclingBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCyclingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.containerLongestRide.setOnClickListener { launchEditCyclingRecordScreen("Longest Ride")  }
        binding.containerBiggestClimb.setOnClickListener { launchEditCyclingRecordScreen("Biggest Climb") }
        binding.containerBestSpeed.setOnClickListener { launchEditCyclingRecordScreen("Best Average Speed") }
    }

}

private fun CyclingFragment.launchEditCyclingRecordScreen(record: String) {
    val intent = Intent(context, EditCyclingRecordActivity::class.java)
    intent.putExtra("Record", record)
    startActivity(intent)
}



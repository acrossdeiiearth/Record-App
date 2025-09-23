package com.acrossdeiiglobe.recordapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.acrossdeiglobe.recordapp.R
import com.acrossdeiglobe.recordapp.databinding.ActivityEditCyclingRecordBinding

class EditCyclingRecordActivity : AppCompatActivity() {


    private lateinit var binding: ActivityEditCyclingRecordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCyclingRecordBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val record = intent.getStringExtra("Record")
        title = "$record Record"

        }
    }

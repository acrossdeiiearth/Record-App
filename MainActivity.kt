package com.acrossdeiglobe.recordapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.acrossdeiglobe.recordapp.databinding.ActivityMainBinding
import com.acrossdeiiglobe.recordapp.CyclingFragment
import com.acrossdeiiglobe.recordapp.RunningFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Set the toolbar as ActionBar (required for 3-dots menu)
        setSupportActionBar(findViewById(R.id.toolbar))

        // Set listener for BottomNavigation
        binding.bottomNav.setOnItemSelectedListener(this)

        // Load default fragment (Running)
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
    }

    // Inflate the overflow menu (3 dots)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu) // toolbar.xml in res/menu
        return true
    }

    // Handle click on menu items (3 dots)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.reset_running -> {
                Toast.makeText(this, "Reset Running clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.reset_cycling -> {
                Toast.makeText(this, "Reset Cycling clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.reset_all -> {
                Toast.makeText(this, "Reset All clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    // Function to load Running fragment
    private fun onRunningClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, RunningFragment())
        }
        return true
    }

    // Function to load Cycling fragment
    private fun onCyclingClicked(): Boolean {
        supportFragmentManager.commit {
            replace(R.id.frame_content, CyclingFragment())
        }
        return true
    }

    // Handle bottom navigation clicks
    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.nav_running -> onRunningClicked()
        R.id.nav_cycling -> onCyclingClicked()
        else -> false
    }
}

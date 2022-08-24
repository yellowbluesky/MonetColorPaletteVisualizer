package com.antony.monetcolorpalettevisualizer

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.color.MaterialColors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val nightModeStateViewModel =
            ViewModelProvider(this).get(NightModeStateViewModel::class.java)

        // variable is only null if the app is freshly started from scratch
        // variable is set to true or false depending on what the current mode is
        // this is important as the default state can vary on system settings
        if (nightModeStateViewModel.nightModeState == null) {
            val nightModeFlags =
                applicationContext.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
            nightModeStateViewModel.nightModeState =
                nightModeFlags == Configuration.UI_MODE_NIGHT_YES
        }

        // Checks if already night mode, and if so sets the state variable


        val colors = mapOf(
            "colorPrimary" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorPrimary,
                Color.BLUE
            ),
            "colorOnPrimary" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnPrimary,
                Color.BLUE
            ),
            "colorPrimaryContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorPrimaryContainer,
                Color.BLUE
            ),
            "colorOnPrimaryContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnPrimaryContainer,
                Color.BLUE
            ),

            "colorSecondary" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorSecondary,
                Color.BLUE
            ),
            "colorOnSecondary" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnSecondary,
                Color.BLUE
            ),
            "colorSecondaryContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorSecondaryContainer,
                Color.BLUE
            ),
            "colorOnSecondaryContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnSecondaryContainer,
                Color.BLUE
            ),

            "colorTertiary" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorTertiary,
                Color.BLUE
            ),
            "colorOnTertiary" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnTertiary,
                Color.BLUE
            ),
            "colorTertiaryContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorTertiaryContainer,
                Color.BLUE
            ),
            "colorOnTertiaryContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnTertiaryContainer,
                Color.BLUE
            ),

            "colorError" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorError,
                Color.BLUE
            ),
            "colorOnError" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnError,
                Color.BLUE
            ),
            "colorErrorContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorErrorContainer,
                Color.BLUE
            ),
            "colorOnErrorContainer" to MaterialColors.getColor(
                this,
                com.google.android.material.R.attr.colorOnErrorContainer,
                Color.BLUE
            ),
        )

        val linearlayout = findViewById<LinearLayout>(R.id.parent)
        for ((text, color) in colors) {
            TextView(this).let {
                it.text = text
                it.height = 128
                if (color.blue > 150 || color.red > 150 || color.green > 150) {
                    it.setTextColor(Color.BLACK)
                } else {
                    it.setTextColor(Color.WHITE)
                }
                it.setBackgroundColor(color)

                it.setOnClickListener {
                    // Copies the color to clipboard
                    (getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager).setPrimaryClip(
                        ClipData.newPlainText("", String.format("#%06X", (0xFFFFFF and color)))
                    )

                    // Toasts the color for a medium length of time
                    Toast.makeText(
                        this,
                        String.format("#%06X", (0xFFFFFF and color)),
                        Toast.LENGTH_LONG
                    ).show()
                }
                linearlayout.addView(it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            menuInflater.inflate(R.menu.menu, it)

            // Sets the correct icon for night.day mode
            val menuItem = it.findItem(R.id.status_icon)
            val nightModeStateViewModel =
                ViewModelProvider(this).get(NightModeStateViewModel::class.java)
            if (nightModeStateViewModel.nightModeState!!) {
                menuItem.setIcon(R.drawable.ic_baseline_wb_sunny_24)
            } else {
                menuItem.setIcon(R.drawable.ic_baseline_nights_stay_24)
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val nightModeStateViewModel =
            ViewModelProvider(this).get(NightModeStateViewModel::class.java)
        nightModeStateViewModel.nightModeState = if (!nightModeStateViewModel.nightModeState!!) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            true
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            false
        }
        return true
    }
}
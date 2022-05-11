package com.antony.monetcolorpalettevisualizer

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.blue
import androidx.core.graphics.green
import androidx.core.graphics.red
import com.google.android.material.color.MaterialColors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            val textView = TextView(this)
            textView.text = text
            textView.height = 128
            if (color.blue > 150 || color.red > 150 || color.green > 150) {
                textView.setTextColor(Color.BLACK)
            } else {
                textView.setTextColor(Color.WHITE)
            }
            textView.setBackgroundColor(color)
            linearlayout.addView(textView)
        }
    }
}
package com.example.localization

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ColourChangeActivity : AppCompatActivity() {

    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    private lateinit var textView3: TextView
    private lateinit var colorChangeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the views
        textView1 = findViewById(R.id.textView1)
        textView2 = findViewById(R.id.textView2)
        textView3 = findViewById(R.id.textView3)
        colorChangeButton = findViewById(R.id.colorChangeButton)

        // Set OnClickListener for the Button
        colorChangeButton.setOnClickListener {
            changeTextColor()
        }
    }

    // Function to change the color of the TextViews
    private fun changeTextColor() {
        textView1.setTextColor(Color.RED)    // Change color to red
        textView2.setTextColor(Color.GREEN)  // Change color to green
        textView3.setTextColor(Color.BLUE)   // Change color to blue
    }
}

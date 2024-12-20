package com.example.localization

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class Toolbar : AppCompatActivity() {
    private lateinit var mainText: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Optional if using edge-to-edge support

        setContentView(R.layout.activity_toolbar)

        // Set the Toolbar as the action bar
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)
        var actionBar = supportActionBar
        actionBar!!.title = "Sample title"
        actionBar!!.subtitle = "Sub title"

        actionBar.setDisplayShowHomeEnabled(true)
//        actionBar.
        // Initialize TextView
        mainText = findViewById(R.id.textView11)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.button1 -> {
                mainText.text = "Button 1 was clicked."
            }
            R.id.button2 -> {
                mainText.text = "Button 2 was clicked."
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

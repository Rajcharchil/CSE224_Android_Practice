package com.example.localization

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.localization.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMenuBinding
    private lateinit var mainText : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)

        val actionBar = supportActionBar
        actionBar!!.title = "Sample title"
        actionBar!!.subtitle = "Sub title"

        actionBar.setDisplayShowHomeEnabled(true)

        mainText = binding.textView11
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
package com.example.myapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_item1 -> {
                Toast.makeText(this, " clicked item1", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_item2 -> {
                Toast.makeText(this, "clicked item2", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.action_item3 -> {
                Toast.makeText(this, " clicked item3", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }
}

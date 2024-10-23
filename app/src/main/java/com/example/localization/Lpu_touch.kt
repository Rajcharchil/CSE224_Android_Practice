package com.example.localization

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class Lpu_touch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lpu_touch)






        val button2:Button = findViewById(R.id.button2)
        button2.setOnClickListener {

            Snackbar.make(button2, "This is a simple Snackbar", Snackbar.LENGTH_LONG).show()
        }

        val button3 = findViewById<Button>(R.id.button3)
        button3.setOnClickListener(){
         // val next = Intent(this@Lpu_touch,zomatooItems::class.java)
          //  startActivity(intent)

           startActivity(Intent(this,zomatooItems::class.java))
        }





        // Set up the toolbar as the ActionBar
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        // Handle window insets for edge-to-edge layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Inflate the menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    // Handle menu item clicks
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.Favorite -> {
                Toast.makeText(this, "Favorite clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.Whatsapp -> {
                Toast.makeText(this, "WhatsApp clicked", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.Instagram -> {
                Toast.makeText(this, "Instagram clicked", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }



    }
}

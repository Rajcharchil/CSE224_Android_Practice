package com.example.localization

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ZomatooSell : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_zomatoo_sell)

        // Handle window insets for the status and navigation bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Button click listeners for purchase buttons
        val btnPurchaseItem1 = findViewById<Button>(R.id.btnPurchaseItem1)
        val btnPurchaseItem2 = findViewById<Button>(R.id.btnPurchaseItem2)
        val btnPurchaseItem3 = findViewById<Button>(R.id.btnPurchaseItem3)

        btnPurchaseItem1.setOnClickListener {
            // Handle purchase item 1 logic here
        }

        btnPurchaseItem2.setOnClickListener {
            // Handle purchase item 2 logic here
        }

        btnPurchaseItem3.setOnClickListener {
            // Handle purchase item 3 logic here
        }

        // Back Button - returns to zomatooItems activity
        val btnBackToItems = findViewById<Button>(R.id.btnBackToItems)
        btnBackToItems.setOnClickListener {
            // Close the current activity and go back to zomatooItems
            finish()
        }
    }
}

package com.example.localization

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Enable edge-to-edge mode
        enableEdgeToEdge()

        // Set the content view to your XML layout
        setContentView(R.layout.activity_main)

        // Handle window insets (system bars) to adjust padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { view, insets ->
            val systemBarsInsets = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            // Adjust the padding of the root view based on system bars (status/navigation)
            view.setPadding(
                systemBarsInsets.left,  // left padding
                systemBarsInsets.top,   // top padding (status bar)
                systemBarsInsets.right, // right padding
                systemBarsInsets.bottom // bottom padding (navigation bar)
            )
            insets
        }

        // Button that triggers the Snackbar
        val snackbarButton = findViewById<Button>(R.id.showSnackbarButton)

        // Set up the click listener for the Snackbar button
        snackbarButton.setOnClickListener {
            Snackbar.make(findViewById(R.id.main), "Welcome to the app!", Snackbar.LENGTH_LONG).setAction("action"){
                val itemDeleted = false
                Toast.makeText(this,"Item restore",Toast.LENGTH_LONG)}.show()
            
        }
    }
}

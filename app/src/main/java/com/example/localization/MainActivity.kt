package com.example.localization

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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

        // Get references to the EditText fields
        val firstNameEditText = findViewById<EditText>(R.id.editTextText4)
        val lastNameEditText = findViewById<EditText>(R.id.editTextText3)
        val emailEditText = findViewById<EditText>(R.id.editTextText2)

        // Button that triggers the "login" action
        val loginButton = findViewById<Button>(R.id.showSnackbarButton)

        // Set up the click listener for the login button
        loginButton.setOnClickListener {
            // Get the input from the EditText fields
            val firstName = firstNameEditText.text.toString().trim()
            val lastName = lastNameEditText.text.toString().trim()
            val email = emailEditText.text.toString().trim()

            // Check if all fields are filled out
            if (firstName.isNotEmpty() && lastName.isNotEmpty() && email.isNotEmpty()) {
                // Show success message using Snackbar
                Snackbar.make(findViewById(R.id.main), "Login Successful", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()

                // Optionally, show a toast with the entered details
                Toast.makeText(this,"Welcome, $firstName $lastName!\nEmail: $email", Toast.LENGTH_LONG).show()

                // TODO: You can add logic here to store the data or navigate to another screen.
            } else {
                // Show an error message if any field is empty
                Snackbar.make(findViewById(R.id.main), "Please fill out all fields", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }
}

package com.example.localization

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivitySignUpPgeBinding
import com.example.localization.databinding.CustomAlertDialogBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpPage : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpPgeBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize binding
        binding = ActivitySignUpPgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        // Set up the login TextView click listener
        binding.textView16.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Set up the sign-up button click listener
        binding.buttonSignUp.setOnClickListener {
            val username = binding.editTextName.text.toString().trim()
            val email = binding.editTextEmail.text.toString().trim()
            val password = binding.editTextPassword.text.toString().trim()

            // Validate input fields
            if (username.isEmpty()) {
                showCustomAlertDialog("Invalid Username", "Please enter your username.")
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                showCustomAlertDialog(
                    "Invalid Email Address",
                    "Please enter a valid email address to proceed."
                )
                return@setOnClickListener
            }
            if (password.length < 6 || !password.contains(Regex("[^a-zA-Z0-9]"))) {
                showCustomAlertDialog(
                    "Invalid Password",
                    "Password must be at least 6 characters long and include a special character."
                )
                return@setOnClickListener
            }

            // Create user with Firebase Authentication
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        // User successfully created
                        Toast.makeText(this, "Sign-up successful!", Toast.LENGTH_SHORT).show()

                        // Redirect to LoginActivity (pass data if needed)
                        val intent = Intent(this, LoginActivity::class.java).apply {
                            putExtra("username", username)
                            putExtra("email", email)
                        }
                        startActivity(intent)
                        finish()
                    } else {
                        // Handle failure
                        val errorMessage = task.exception?.message ?: "Sign-up failed."
                        showCustomAlertDialog("Error", errorMessage)
                    }
                }
        }
    }

    // Function to show a custom AlertDialog
    private fun showCustomAlertDialog(title: String, message: String) {
        val dialogBinding = CustomAlertDialogBinding.inflate(LayoutInflater.from(this))
        val dialog = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .setCancelable(false)
            .create()

        dialogBinding.alertTitle.text = title
        dialogBinding.alertMessage.text = message
        dialogBinding.alertButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}

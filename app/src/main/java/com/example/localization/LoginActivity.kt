package com.example.localization

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.localization.databinding.ActivityLoginBinding
import com.example.localization.databinding.CustomAlertDialogBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var googleSignInClient: GoogleSignInClient
    private val RC_SIGN_IN = 9001  // Result code for Google Sign-In

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize binding
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        // Initialize Google Sign-In
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_clint_ID))  // Your Web Client ID from Firebase
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(this, gso)

        // Set up Google Sign-In button click listener
        binding.button4.setOnClickListener {
            signInWithGoogle()
        }

        // Pre-fill email from signup page
        val receivedEmail = intent.getStringExtra("email")
        if (!receivedEmail.isNullOrEmpty()) {
            binding.editTextEmailLogin.setText(receivedEmail)
        }
        binding.editTextPasswordLogin.setText("")

        // Set up regular login button click listener
        binding.buttonLogin.setOnClickListener {
            val enteredEmail = binding.editTextEmailLogin.text.toString().trim()
            val enteredPassword = binding.editTextPasswordLogin.text.toString().trim()

            if (!Patterns.EMAIL_ADDRESS.matcher(enteredEmail).matches()) {
                showAlertDialog("Invalid Email Address", "Please enter a valid email address.")
                return@setOnClickListener
            }
            if (enteredPassword.isEmpty() || enteredPassword.length < 6) {
                showAlertDialog("Invalid Password", "Password must be at least 6 characters long.")
                return@setOnClickListener
            }

            firebaseAuth.signInWithEmailAndPassword(enteredEmail, enteredPassword)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val user = firebaseAuth.currentUser
                        Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        showAlertDialog("Login Failed", task.exception?.message ?: "Login failed. Please try again.")
                    }
                }
        }

        // Set up forgot password click listener
        binding.forgetPasscode.setOnClickListener {
            val intent = Intent(this, ForgetPassActivity::class.java)
            startActivity(intent)
        }

        // Set up sign-up text click listener
        binding.textViewSignup.setOnClickListener {
            val intent = Intent(this, SignUpPage::class.java)
            startActivity(intent)
        }
    }

    private fun signInWithGoogle() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                Toast.makeText(this, "Google Sign-In failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        if (account != null) {
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = firebaseAuth.currentUser
                        Toast.makeText(this, "Google Sign-In successful!", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        showAlertDialog("Authentication Failed", task.exception?.message ?: "Please try again.")
                    }
                }
        }
    }

    private fun showAlertDialog(title: String, message: String) {
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

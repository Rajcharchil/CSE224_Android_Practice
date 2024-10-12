package com.example.localization

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity2_Intent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_activity2_intent)

//         Button to open Google
        val openGoogleButton = findViewById<MaterialButton>(R.id.openGoogleButton)
        openGoogleButton.setOnClickListener {
            val googleIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(googleIntent)
        }

        // Button to open Camera
        val openCameraButton = findViewById<MaterialButton>(R.id.openCameraButton)
        openCameraButton.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (cameraIntent.resolveActivity(packageManager) != null) {
                startActivity(cameraIntent)
            } else {
                Toast.makeText(this, "No camera app found", Toast.LENGTH_SHORT).show()
            }
        }

        // Button to make a Phone Call
        val makeCallButton = findViewById<MaterialButton>(R.id.makeCallButton)
        makeCallButton.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:9430874685") // Replace with a real number
            startActivity(callIntent)
        }

        // Button to share something
        val shareButton = findViewById<MaterialButton>(R.id.shareButton)
        shareButton.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "This is something I'd like to share!") // Change to what you want to share
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

//         Verify Button with Toast Message
        val verifyButton = findViewById<Button>(R.id.button)
        verifyButton.setOnClickListener {
            Toast.makeText(this, "Verification in progress...", Toast.LENGTH_SHORT).show()
        }
    }
}

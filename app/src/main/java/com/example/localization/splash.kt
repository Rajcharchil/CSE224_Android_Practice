package com.example.yourapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import com.example.localization.MainActivity
import com.example.localization.R

class SplashActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private var progressStatus = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Initialize the progress bar
        progressBar = findViewById(R.id.progressBar)

        // Simulate loading progress for 3 seconds (3000 milliseconds)
        Thread {
            while (progressStatus < 100) {
                progressStatus += 1
                handler.post {
                    progressBar.progress = progressStatus
                }
                try {
                    // Sleep for 30 milliseconds to simulate progress
                    Thread.sleep(30)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
            // After progress completes, open the main activity (LPU Touch)
            handler.post {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                startActivity(intent)
                finish() // Finish the splash screen activity so user can't return to it
            }
        }.start()
    }
}

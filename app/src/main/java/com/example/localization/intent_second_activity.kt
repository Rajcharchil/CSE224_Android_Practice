package com.example.localization

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class intent_second_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_intent_second)

        val message1 = intent.getStringExtra("message1")
        val message2 = intent.getStringExtra("message2")
        val message3 = intent.getStringExtra("message3")

        val textView = findViewById<TextView>(R.id.txt)
        textView.text = " Name: $message1\nFavorite Colour : $message2\nFavorite Animal: $message3"

    }
}
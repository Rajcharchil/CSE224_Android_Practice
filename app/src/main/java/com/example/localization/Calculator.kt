package com.example.localization

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Calculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_calculator)
        // Reference UI elements
        val etNumber1 = findViewById<EditText>(R.id.etNumber1)
        val etNumber2 = findViewById<EditText>(R.id.etNumber2)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val btnSubtract = findViewById<Button>(R.id.btnSubtract)
        val btnMultiply = findViewById<Button>(R.id.btnMultiply)
        val btnDivide = findViewById<Button>(R.id.btnDivide)

        // Set up button click listeners
        btnAdd.setOnClickListener {
            val result = getNumber(etNumber1) + getNumber(etNumber2)
            tvResult.text = "Result: $result"
        }

        btnSubtract.setOnClickListener {
            val result = getNumber(etNumber1) - getNumber(etNumber2)
            tvResult.text = "Result: $result"
        }

        btnMultiply.setOnClickListener {
            val result = getNumber(etNumber1) * getNumber(etNumber2)
            tvResult.text = "Result: $result"
        }

        btnDivide.setOnClickListener {
            val number2 = getNumber(etNumber2)
            if (number2 != 0.0) {
                val result = getNumber(etNumber1) / number2
                tvResult.text = "Result: $result"
            } else {
                tvResult.text = "Error: Division by zero"
            }
        }
    }

    // Helper function to safely parse numbers
    private fun getNumber(editText: EditText): Double {
        return editText.text.toString().toDoubleOrNull() ?: 0.0
    }
    }

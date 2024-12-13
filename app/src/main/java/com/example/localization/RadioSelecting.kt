package com.example.localization

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class RadioSelecting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_selecting)


        val radioGroupGender = findViewById<RadioGroup>(R.id.radioGroupGender)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvResult = findViewById<TextView>(R.id.tvResult)


        btnSubmit.setOnClickListener {

            val selectedId = radioGroupGender.checkedRadioButtonId
            if (selectedId != -1) {

                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val gender = selectedRadioButton.text.toString()
                tvResult.text = "Selected Gender: $gender"
                Toast.makeText(this, "seriously your gender is $gender", Toast.LENGTH_SHORT).show()
            } else {

                Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

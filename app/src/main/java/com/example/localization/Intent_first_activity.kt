package com.example.localization

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class Intent_first_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_first)

        val editText1 = findViewById<EditText>(R.id.editText)
        val editText2 = findViewById<EditText>(R.id.et1)
        val editText3 = findViewById<EditText>(R.id.et2)
        val buttonSend = findViewById<Button>(R.id.buttonSend)

        buttonSend.setOnClickListener {
            val message1 = editText1.text.toString()
            val message2 = editText2.text.toString()
            val message3 = editText3.text.toString()



            val intent = Intent(this, intent_second_activity::class.java).apply {
                putExtra("message1", message1)
                putExtra("message2", message2)
                putExtra("message3", message3)
            }
            startActivity(intent)

            Snackbar.make(buttonSend, "Messages sent!", Snackbar.LENGTH_LONG).show()
        }
    }
}

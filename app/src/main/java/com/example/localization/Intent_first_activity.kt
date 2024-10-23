package com.example.localization

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Intent_first_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_first)


        val editText = findViewById<EditText>(R.id.editText)
        val buttonSend = findViewById<Button>(R.id.buttonSend)


        buttonSend.setOnClickListener {

            val message = editText.text.toString()

            startActivity(Intent(this,intent_second_activity::class.java).putExtra("message",message))
//
        //  val intent = Intent(this, intent_second_activity::class.java).apply {
//                putExtra("message", message)
//            }
//
//
//            startActivity(intent)
        }
    }
}

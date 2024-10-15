package com.example.localization

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MotionEvent
import android.view.View
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.concurrent.TimeUnit

class zomatooItems : AppCompatActivity() {
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_zomatoo_items)

        // Handle window insets (for status and navigation bar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Button to navigate to ZomatooSell activity
        val btnGoToSell = findViewById<Button>(R.id.btnGoToSell)
        btnGoToSell.setOnClickListener {
            val intent = Intent(this@zomatooItems, ZomatooSell::class.java)
            startActivity(intent)
        }

        // Make ImageView2 movable
        val imageView2 = findViewById<ImageView>(R.id.imageView2)
        imageView2.setOnTouchListener(object : View.OnTouchListener {
            var dX = 0f
            var dY = 0f
            override fun onTouch(view: View, event: MotionEvent): Boolean {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        dX = view.x - event.rawX
                        dY = view.y - event.rawY
                    }
                    MotionEvent.ACTION_MOVE -> {
                        view.animate()
                            .x(event.rawX + dX)
                            .y(event.rawY + dY)
                            .setDuration(0)
                            .start()
                    }
                }
                return true
            }
        })

        // Set up countdown timer
        val countdownTextView = findViewById<TextView>(R.id.countdownTimer)
        startCountdownTimer(countdownTextView, 2 * 60 * 60 * 1000) // 2 hours in milliseconds

        // Animate the text "Climate Conscious Delivery In India" horizontally
        val textView = findViewById<TextView>(R.id.textView)

        // Wait until the TextView is laid out before starting the animation
        textView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                textView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                startTextScrollAnimation(textView)
            }
        })
    }

    // Function to start a countdown timer
    private fun startCountdownTimer(textView: TextView, duration: Long) {
        object : CountDownTimer(duration, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished)
                val minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished) % 60
                val seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) % 60
                val timeString = String.format("Offer ends in 👉 %02d:%02d:%02d", hours, minutes, seconds)
                textView.text = timeString
            }

            override fun onFinish() {
                textView.text = "Offer has ended!"
            }
        }.start()
    }

    // Function to animate the text view horizontally using ObjectAnimator
    private fun startTextScrollAnimation(view: View) {
        // Get the width of the screen and the TextView
        val parentWidth = (view.parent as View).width
        val textWidth = view.width

        // Create ObjectAnimator to scroll the text from left to right
        val animator = ObjectAnimator.ofFloat(view, "translationX", -textWidth.toFloat(), parentWidth.toFloat())
        animator.duration = 7000 // Duration of the animation (5 seconds)
        animator.repeatCount = ObjectAnimator.INFINITE // Repeat indefinitely
        animator.repeatMode = ObjectAnimator.REVERSE // Start over after each iteration
        animator.start()
    }
}

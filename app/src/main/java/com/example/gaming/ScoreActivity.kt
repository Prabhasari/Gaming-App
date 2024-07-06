package com.example.gaming

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score)

        val scoreTextView = findViewById<TextView>(R.id.scoreTextView)
        val highScoreTextView = findViewById<TextView>(R.id.highScoreTextView)

        // Get scores from Intent extras
        val score = intent.getIntExtra("SCORE", 0)
        val highestScore = intent.getIntExtra("HIGH_SCORE", 0)

        // Display the scores
        scoreTextView.text = "Score: $score"
        highScoreTextView.text = "Highest Score: $highestScore"

        //Optionally, you can format the score text with string resources
         //scoreTextView.text = getString(R.string.score_format, score)
         //highScoreTextView.text = getString(R.string.high_score_format, highestScore)

        // Set a click listener for the Start Again button
        val startButton = findViewById<Button>(R.id.startButton)
        startButton.setOnClickListener {
            // Start the game again by navigating back to MainActivity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Finish this activity to prevent going back to it when pressing back
        }
    }
}
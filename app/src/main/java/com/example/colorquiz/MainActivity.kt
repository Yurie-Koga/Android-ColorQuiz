package com.example.colorquiz

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Toast.LENGTH_SHORT
import androidx.core.content.ContextCompat
import com.example.colorquiz.data.*

class MainActivity : AppCompatActivity() {

    lateinit var color1Button: Button
    lateinit var color2Button: Button
    lateinit var scoreLabel: TextView
    lateinit var colorLabel: TextView
    lateinit var nextButton: Button
    var curScore = 0
    lateinit var questions: List<Question>
    lateinit var curQuestion: Question
    var curAnswer = 0

    @SuppressLint("ResourceAsColor", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        color1Button = findViewById(R.id.color_1_button)
        color1Button.setOnClickListener { selectColor(1) }
        color2Button = findViewById(R.id.color_2_button)
        color2Button.setOnClickListener { selectColor(2) }

        scoreLabel = findViewById(R.id.score_label)
        colorLabel = findViewById(R.id.color_label)
        nextButton = findViewById(R.id.next_button)
        nextButton.setOnClickListener { goNext() }

        questions = generateQuestion()
        goNext()

        updateScore(0)
    }

    /**
     * Event when Color buttons are clicked
     */
    private fun selectColor(buttonNum: Int) {
        if (!nextButton.isEnabled) checkAnswer(buttonNum)
    }

    /**
     * Check answer and update score
     * Next button will be enabled
     */
    private fun checkAnswer(buttonNum: Int) {
        if (curAnswer == buttonNum ) {
            updateScore(curScore++)
            Toast.makeText(this, "Right", LENGTH_SHORT).show()
        } else {
            updateScore(curScore--)
            Toast.makeText(this, "Wrong", LENGTH_SHORT).show()
        }
        nextButton.isEnabled = true
    }

    /**
     * Update score label
     */
    private fun updateScore(value: Int) {
        val score = "Score: $curScore"
        scoreLabel.text = score
    }

    /**
     * Display next question
     * Next button will be disabled
     */
    private fun goNext() {
        var qNum = (0 until questions.count()).random()
        curAnswer = (1..2).random()

        curQuestion = questions[qNum]
        color1Button.setBackgroundColor(ContextCompat.getColor(this, curQuestion.colorId1))
        color2Button.setBackgroundColor(ContextCompat.getColor(this, curQuestion.colorId2))
        if (curAnswer == 1) {
            colorLabel.text = resources.getResourceEntryName(curQuestion.colorId1)
        } else {
            colorLabel.text = resources.getResourceEntryName(curQuestion.colorId2)
        }
        nextButton.isEnabled = false
    }
}



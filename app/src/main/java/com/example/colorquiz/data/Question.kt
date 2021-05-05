package com.example.colorquiz.data

import com.example.colorquiz.R

data class Question(val questionId: Int, val colorId1: Int, val colorId2: Int) {

}

/**
 * Generate color questions
 * To add new colors, add new entries into res > colors.xml
 */
fun generateQuestion(): List<Question> {
    val questions = mutableListOf<Question>()
    questions.add(Question(1, R.color.red, R.color.gray))
    questions.add(Question(2, R.color.pink, R.color.white))
    questions.add(Question(3, R.color.blue, R.color.yellow))
    questions.add(Question(4, R.color.yellow_green, R.color.pink))
    questions.add(Question(5, R.color.yellow, R.color.black))
    questions.add(Question(6, R.color.sky_blue, R.color.red))
    questions.add(Question(7, R.color.black, R.color.sky_blue))
    questions.add(Question(8, R.color.gray, R.color.yellow_green))
    questions.add(Question(9, R.color.white, R.color.blue))
    questions.add(Question(10, R.color.pink, R.color.sky_blue))
    return questions
}
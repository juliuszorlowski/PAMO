package com.example.tipper

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import com.example.tipper.databinding.FragmentQuizBinding

class QuizFragment : Fragment() {

    private lateinit var binding: FragmentQuizBinding
    private var rightAnswer: String? = null
    private var rightAnswerCount = 0
    private var quizCount = 1
    private val QUIZ_COUNT = 5

    private val quizData = mutableListOf(
        // country, capital, choice1, choice2, choice3
        mutableListOf("China", "Beijing", "Jakarta", "Manila", "Stockholm"),
        mutableListOf("India", "New Delhi", "Beijing", "Bangkok", "Seoul"),
        mutableListOf("Indonesia", "Jakarta", "Manila", "New Delhi", "Kuala Lumpur"),
        mutableListOf("Japan", "Tokyo", "Bangkok", "Taipei", "Jakarta"),
        mutableListOf("Thailand", "Bangkok", "Berlin", "Havana", "Kingston"),
        mutableListOf("Brazil", "Brasilia", "Havana", "Bangkok", "Copenhagen"),
        mutableListOf("Canada", "Ottawa", "Bern", "Copenhagen", "Jakarta"),
        mutableListOf("Cuba", "Havana", "Bern", "London", "Mexico City"),
        mutableListOf("Mexico", "Mexico City", "Ottawa", "Berlin", "Santiago"),
        mutableListOf("United States", "Washington D.C.", "San Jose", "Buenos Aires", "Kuala Lumpur"),
        mutableListOf("France", "Paris", "Ottawa", "Copenhagen", "Tokyo"),
        mutableListOf("Germany", "Berlin", "Copenhagen", "Bangkok", "Santiago"),
        mutableListOf("Italy", "Rome", "London", "Paris", "Athens"),
        mutableListOf("Spain", "Madrid", "Mexico City", "Jakarta", "Havana"),
        mutableListOf("United Kingdom", "London", "Rome", "Paris", "Singapore"),
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?
    ): View {

        binding = FragmentQuizBinding.inflate(layoutInflater)
        val view = binding.root

        // Shuffle quiz.
        quizData.shuffle()

        showNextQuiz()

        return view
    }

    fun showNextQuiz() {
        // Update countLabel.
        binding.countLabel.text = getString(R.string.count_label, quizCount)


        // Pick one quiz set.
        val quiz = quizData[0]

        // Set question & rightAnswer.
        binding.questionLabel.text = quiz[0]
        rightAnswer = quiz[1]

        // Remove "Country" from quiz.
        quiz.removeAt(0)

        // Shuffle answer & choices.
        quiz.shuffle()

        // Set choices.
        binding.answerBtn1.text = quiz[0]
        binding.answerBtn2.text = quiz[1]
        binding.answerBtn3.text = quiz[2]
        binding.answerBtn4.text = quiz[3]

        // Remove this quiz from quizData.
        quizData.removeAt(0)
    }
/*
    fun checkAnswer(view: View) {
        // Get pushed button.
        val answerBtn: Button = findViewById(view.id)
        val btnText = answerBtn.text.toString()

        val alertTitle: String
        if (btnText == rightAnswer) {
            // Correct
            alertTitle = "Correct!"
            rightAnswerCount++;
        } else {
            // Wrong
            alertTitle = "Wrong..."
        }

        // Create Dialog.
        AlertDialog.Builder(this)
            .setTitle(alertTitle)
            .setMessage("Answer: $rightAnswer")
            .setPositiveButton("OK") {dialogInterface, i ->
                checkQuizCount()
            }
            .setCancelable(false)
            .show()
    }

    fun checkQuizCount() {
        if (quizCount == QUIZ_COUNT) {
            // Show Result.

        } else {
            quizCount++
            showNextQuiz()
        }
    }*/
}
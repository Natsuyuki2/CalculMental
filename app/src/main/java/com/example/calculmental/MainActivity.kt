package com.example.calculmental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.calculmental.model.TheVoice
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val theVoice = TheVoice(applicationContext)

        val nouvelleQuestionBoutton : Button = findViewById(R.id.nouvelleQuestion_button)
        nouvelleQuestionBoutton.setOnClickListener {
            theVoice.nouvelleQuestion()
        }
        val repeteLaQuestion : Button = findViewById(R.id.repeter)
        repeteLaQuestion.setOnClickListener {
            theVoice.repeteLaQuestion()
        }
    }
}

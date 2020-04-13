package com.example.calculmental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.calculmental.model.PaveNumerique
import com.example.calculmental.model.TheVoice
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val paveNumerique = PaveNumerique()

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
        val bouton1 : Button = findViewById(R.id.keypad1_button)
        val resultat : TextView = findViewById(R.id.resultat_text)
        bouton1.setOnClickListener {
            resultat.text = paveNumerique.saisirChiffre("1")

        }
        val bouton2 : Button = findViewById(R.id.keypad2_button)
        bouton2.setOnClickListener {
            resultat.text = paveNumerique.saisirChiffre("2")
        }
    }
}

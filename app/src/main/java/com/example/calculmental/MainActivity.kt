package com.example.calculmental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculmental.databinding.ActivityMainBinding
import com.example.calculmental.model.PaveNumerique
import com.example.calculmental.model.TheVoice
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val paveNumerique = PaveNumerique()

        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        val theVoice = TheVoice(applicationContext)

//        val nouvelleQuestionBoutton : Button = findViewById(R.id.nouvelleQuestion_button)
//        nouvelleQuestionBoutton.setOnClickListener {
//            theVoice.nouvelleQuestion()
//        }
//        val repeteLaQuestion : Button = findViewById(R.id.repeter)
//        repeteLaQuestion.setOnClickListener {
//            theVoice.repeteLaQuestion()
//        }
//        val bouton1 : Button = findViewById(R.id.keypad1_button)
//        val resultat : TextView = findViewById(R.id.resultat_text)
//        bouton1.setOnClickListener {
//            resultat.text = paveNumerique.saisirChiffre("1")
//
//        }
//        val bouton2 : Button = findViewById(R.id.keypad2_button)
//        bouton2.setOnClickListener {
//            resultat.text = paveNumerique.saisirChiffre("2")
//        }


        binding.nouvelleQuestionButton.setOnClickListener { theVoice.nouvelleQuestion() }
        binding.repeter.setOnClickListener { theVoice.repeteLaQuestion() }

        binding.keypad10Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("0") }
        binding.keypad1Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("1") }
        binding.keypad2Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("2") }
        binding.keypad3Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("3") }
        binding.keypad4Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("4") }
        binding.keypad5Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("5") }
        binding.keypad6Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("6") }
        binding.keypad7Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("7") }
        binding.keypad8Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("8") }
        binding.keypad9Button.setOnClickListener { binding.resultatText.text = paveNumerique.saisirChiffre("9") }

        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        binding.keypad11Button.setOnClickListener {
            var bonResultat = theVoice.donneMoiLeResultat()
            var resultatUtilisateur = paveNumerique.valide()

            if (bonResultat == resultatUtilisateur) {
                Toast.makeText(applicationContext, "BIEN!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"OUPS,PERDU!",Toast.LENGTH_SHORT).show()
            }
        }
    }
}

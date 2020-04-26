package com.example.calculmental

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.calculmental.databinding.ActivityMainBinding
import com.example.calculmental.model.PaveNumerique
import com.example.calculmental.model.TheVoice
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        theVoice = TheVoice(applicationContext)

        setOnClickListener()

        setContentView(binding.root)

        binding.keypad11Button.setOnClickListener {
            var resultatUtilisateur = paveNumerique.valide()

            var bonResultat = theVoice.donneMoiLeResultat()
            if (bonResultat == resultatUtilisateur) {
                Toast.makeText(applicationContext, "BIEN!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext,"OUPS,PERDU!",Toast.LENGTH_SHORT).show()
            }
        }

        theVoice.isPlaying.observe(this, Observer {
            when(it){
                true -> desactiveLesBoutons()
                false -> activeLesBoutons()
            }
        })
    }

    private fun desactiveLesBoutons() {
        binding.allBoutonEnable = false
    }

    private fun activeLesBoutons() {
        binding.allBoutonEnable = true
    }

    val paveNumerique = PaveNumerique()

    lateinit var theVoice : TheVoice

    fun setOnClickListener() {

        binding.nouvelleQuestionButton.setOnClickListener {
            theVoice.nouvelleQuestion()
            binding.questionEcrite.text = theVoice.ecritLaQuestion()
        }

        binding.repeter.setOnClickListener { theVoice.repeteLaQuestion() }

        binding.keypad10Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("0")
        }
        binding.keypad1Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("1")
        }
        binding.keypad2Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("2")
        }
        binding.keypad3Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("3")
        }
        binding.keypad4Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("4")
        }
        binding.keypad5Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("5")
        }
        binding.keypad6Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("6")
        }
        binding.keypad7Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("7")
        }
        binding.keypad8Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("8")
        }
        binding.keypad9Button.setOnClickListener {
            binding.resultatText.text = paveNumerique.saisirChiffre("9")
        }
        binding.supprimerBouton.setOnClickListener {
            binding.resultatText.text = paveNumerique.supprimerChiffre()
        }

    }
}

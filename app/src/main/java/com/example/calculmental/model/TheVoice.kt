package com.example.calculmental.model

import android.content.Context
import android.media.MediaPlayer
import androidx.lifecycle.MutableLiveData
import com.example.calculmental.R
import java.util.*

class TheVoice (private val context : Context) : CalculMental {

    var auMoinsUneFois = false

    override fun nouvelleQuestion() {

        membreDeGauche = Random().nextInt(10) + 1

        membreDeDroite = Random().nextInt(10) + 1

        operation = Random().nextInt(2) + 1

        if (membreDeGauche < membreDeDroite && operation == 2) {
            inversionSoustraction = membreDeGauche
            membreDeGauche = membreDeDroite
            membreDeDroite = inversionSoustraction
        }


        idDesSonsALire = listOf(
            listeDesNombres[membreDeGauche - 1],
            listeDesOperation[operation - 1],
            listeDesNombres[membreDeDroite - 1],
            R.raw.lianah_egal)

        caseALire = 0
        lire()
        auMoinsUneFois = true
    }

    private fun lire() {

        player = MediaPlayer.create(context, idDesSonsALire!![caseALire])

        player?.setOnCompletionListener {
            player?.release()
            caseALire += 1

            if (caseALire < idDesSonsALire!!.size) {
                lire()
            }
            else {
                isPlaying.value = false
            }
        }

        player?.start()
        isPlaying.value = true

    }

    override fun repeteLaQuestion() {
        if (auMoinsUneFois == true) {
            caseALire = 0
            lire()
        }

    }

    var inversionSoustraction : Int = 0
    var symbolOperation : String = ""
    var bonResultat = 0
    var questionEcrite : String = ""

    override fun donneMoiLeResultat(): Int {

        if (operation == 1 ) {
            bonResultat = membreDeGauche + membreDeDroite
        }
        else {
            bonResultat = membreDeGauche - membreDeDroite
        }

        return bonResultat
    }

    override fun ecritLaQuestion(): String {

        if (operation == 1 ) {
            symbolOperation = "+"
        }
        else {
            symbolOperation = "-"
        }

        questionEcrite = "${membreDeGauche.toString()} $symbolOperation ${membreDeDroite.toString()} = "

        return questionEcrite
    }

    private val listeDesNombres = listOf(
        R.raw.lianah_1,
        R.raw.lianah_2,
        R.raw.lianah_3,
        R.raw.lianah_4,
        R.raw.lianah_5,
        R.raw.lianah_6,
        R.raw.lianah_7,
        R.raw.lianah_8,
        R.raw.lianah_9,
        R.raw.lianah_10)

    private val listeDesOperation = listOf(
        R.raw.lianah_plus,
        R.raw.lianah_moins)

    private var membreDeGauche : Int = 0
    private var membreDeDroite : Int = 0
    private var operation : Int = 0
    private var player : MediaPlayer? = null

    private var idDesSonsALire : List<Int>? = null

    private var caseALire : Int = 0

    var isPlaying = MutableLiveData<Boolean>()

    init {
        isPlaying.value = false
    }

}

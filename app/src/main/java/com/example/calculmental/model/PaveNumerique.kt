package com.example.calculmental.model

class PaveNumerique : Clavier {

    override fun saisirChiffre(chiffre: String): String {
        nombreSaisit += chiffre

        return nombreSaisit
    }

    override fun valide(): Int {
        if (nombreSaisit != "") {
            resultat = nombreSaisit.toInt()
        }
        return resultat

    }

    override fun supprimerChiffre(): String {
        if (nombreSaisit != "") {
            nombreSaisit = nombreSaisit.substring(0, nombreSaisit.length - 1)
        }
        return nombreSaisit
    }

    private var nombreSaisit : String = ""
    private var resultat : Int = 0

}
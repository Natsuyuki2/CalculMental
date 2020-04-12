package com.example.calculmental.model

class PaveNumerique : Clavier {

    override fun saisirChiffre(chiffre: String): String {
        nombreSaisit += chiffre

        return nombreSaisit
    }

    override fun valide(): Int {
        resultat = nombreSaisit.toInt()
        return resultat

    }

    override fun supprimerChiffre(): String {
        TODO("Not yet implemented")
    }

    var nombreSaisit : String = ""
    var resultat : Int = 0

}
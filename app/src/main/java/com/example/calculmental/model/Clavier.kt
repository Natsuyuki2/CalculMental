package com.example.calculmental.model

interface Clavier {

    fun saisirChiffre(chiffre : String) : String

    fun valide() : Int

    fun supprimerChiffre() : String
}
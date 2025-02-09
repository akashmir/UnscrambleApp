package com.example.unscramble2


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class GameViewModel : ViewModel() {


    private lateinit var currentWord : String
    var suffledWord by mutableStateOf(selectAndshuffle())
        private set
    var guess by mutableStateOf("")
        private set
    var score by mutableIntStateOf(0)
        private set

    private fun selectAndshuffle(): String {   //picks the word and shuffles it and return the shuffled word
        currentWord = allWords.random()

        val tempWord = currentWord.toCharArray()
        tempWord.shuffle()

        while (String(tempWord) == currentWord){
            tempWord.shuffle()
           }
        return String(tempWord)
    }

    fun userGuess(guessedWord: String) {      //takes user guess and stores in guess
           guess= guessedWord
    }


    fun checkUserGuess() {                    //checks if the user guess is correct and updates the score
              if(guess == currentWord){
                  guess = ""
                  suffledWord = selectAndshuffle()
                  score += SCORE_INCREASE

              }
        else{
                  guess = ""

              }
    }
    fun skipWord(){                       //skips the word and updates the score
        guess = ""
        suffledWord = selectAndshuffle()

    }






}
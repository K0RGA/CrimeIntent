package com.example.crimeintent

import androidx.lifecycle.ViewModel

class CrimeListViewModel : ViewModel() {
    var crimes = mutableListOf<Crime>()

    init {
        for (i in 0 until 100){
            val crime = Crime()
            crime.title = "Crime №$i"
            crime.isSolved = i % 2 == 0
            crimes += crime
        }
    }
}
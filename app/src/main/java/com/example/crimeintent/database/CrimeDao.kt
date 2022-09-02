package com.example.crimeintent.database

import androidx.room.Dao
import androidx.room.Query
import com.example.crimeintent.Crime
import java.util.*

@Dao
interface CrimeDao {
    @Query("Select * from crime")
    fun getCrimes(): List<Crime>

    @Query("Select * from crime where id=(:id)")
    fun getCrime(id: UUID): Crime?
}
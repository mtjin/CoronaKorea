package com.mtjin.coronakorea.data.city.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.country.CountryResponse

@Dao
interface CityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCity(city: CityResponse)

    @Query("SELECT * FROM city LIMIT 1")
    fun getCountry(): CountryResponse?
}
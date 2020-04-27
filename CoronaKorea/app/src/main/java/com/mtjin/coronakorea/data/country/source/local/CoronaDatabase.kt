package com.mtjin.coronakorea.data.country.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mtjin.coronakorea.data.country.CountryResponse


@Database(entities = [CountryResponse::class], version = 1, exportSchema = false)
abstract class CoronaDatabase : RoomDatabase() {
    abstract fun countryDao() : CountryDao
}
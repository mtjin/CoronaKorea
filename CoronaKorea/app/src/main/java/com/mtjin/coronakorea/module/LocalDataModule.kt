package com.mtjin.coronakorea.module

import androidx.room.Room
import com.mtjin.coronakorea.data.country.source.local.CoronaDatabase
import com.mtjin.coronakorea.data.country.source.local.CountryDao
import com.mtjin.coronakorea.data.country.source.local.CountryLocalDataSource
import com.mtjin.coronakorea.data.country.source.local.CountryLocalDataSourceImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val localDataModule: Module = module {
    single<CountryLocalDataSource> { CountryLocalDataSourceImpl(get()) }
    single<CountryDao> { get<CoronaDatabase>().countryDao() }
    single<CoronaDatabase> {
        Room.databaseBuilder(
            get(),
            CoronaDatabase::class.java, "Corona.db"
        )
            .allowMainThreadQueries()
            .build()
    }

}
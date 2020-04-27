package com.mtjin.coronakorea.module

import com.mtjin.coronakorea.data.country.source.CountryRepository
import com.mtjin.coronakorea.data.country.source.CountryRepositoryImpl
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModule: Module = module {
    single<CountryRepository> { CountryRepositoryImpl(get(), get(), get()) }
}
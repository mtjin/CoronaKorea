package com.mtjin.coronakorea.data.country.source

import com.mtjin.coronakorea.data.country.source.local.CountryLocalDataSource
import com.mtjin.coronakorea.data.country.source.remote.CountryRemoteDataSource
import com.mtjin.coronakorea.utils.NetworkManager

class CountryRepositoryImpl(
    private val countryRemoteDataSource: CountryRemoteDataSource,
    private val countryLocalDataSource: CountryLocalDataSource,
    private val networkManager: NetworkManager
) : CountryRepository{

}
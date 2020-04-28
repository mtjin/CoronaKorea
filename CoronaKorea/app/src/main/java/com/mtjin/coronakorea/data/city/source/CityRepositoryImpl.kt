package com.mtjin.coronakorea.data.city.source

import com.mtjin.coronakorea.data.city.source.local.CityLocalDataSource
import com.mtjin.coronakorea.data.city.source.remote.CityRemoteDataSource
import com.mtjin.coronakorea.utils.NetworkManager

class CityRepositoryImpl(
    private val cityRemoteDataSource: CityRemoteDataSource,
    private val cityLocalDataSource: CityLocalDataSource,
    private val networkManager: NetworkManager
) : CityRepository
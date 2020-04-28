package com.mtjin.coronakorea.data.city.source

import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.city.Korea
import com.mtjin.coronakorea.data.city.source.local.CityLocalDataSource
import com.mtjin.coronakorea.data.city.source.remote.CityRemoteDataSource
import com.mtjin.coronakorea.utils.NetworkManager

class CityRepositoryImpl(
    private val cityRemoteDataSource: CityRemoteDataSource,
    private val cityLocalDataSource: CityLocalDataSource,
    private val networkManager: NetworkManager
) : CityRepository {
    override fun getSearchCity(success: (CityResponse) -> Unit, fail: (Throwable) -> Unit) {
        if (networkManager.checkNetworkState()) {
            cityRemoteDataSource.getCity(
                success = {
                    success(it)
                },
                fail = {
                    fail(Throwable())
                }
            )
        } else {
            fail(Throwable())
        }
    }

    override fun getSearchKorea(success: (Korea) -> Unit, fail: (Throwable) -> Unit) {
        if (networkManager.checkNetworkState()) {
            //캐싱은 애니메이션 효과때문에 없는게 나은듯
            //remote
            cityRemoteDataSource.getCity(
                success = {
                    cityLocalDataSource.insertKorea(it.korea)
                    success(it.korea)
                },
                fail = {
                    fail(Throwable())
                }
            )
        } else {
            //local
            cityLocalDataSource.getKorea()?.let { success(it) }
        }
    }
}
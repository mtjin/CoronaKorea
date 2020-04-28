package com.mtjin.coronakorea.data.city.source

import com.mtjin.coronakorea.data.city.CityResponse
import com.mtjin.coronakorea.data.city.Korea

interface CityRepository {
    fun getSearchCity(
        success: (CityResponse) -> Unit,
        fail: (Throwable) -> Unit
    )

    fun getSearchKorea(
        success: (Korea) -> Unit,
        fail: (Throwable) -> Unit
    )
}
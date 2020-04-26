package com.mtjin.coronakorea.api

import com.mtjin.coronakorea.data.korea.KoreaResponse
import com.mtjin.coronakorea.data.total.TotalResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("korea/country/new/")
    fun getCountriesInfo(
        @Query("serviceKey") serviceKey: String = "3808684a386e1a1b7e0e5faf9c5a4a223"
    ): Call<KoreaResponse>

    @GET("korea/")
    fun getTotalCountInfo(
        @Query("serviceKey") serviceKey: String = "3808684a386e1a1b7e0e5faf9c5a4a223"
    ): Call<TotalResponse>
}
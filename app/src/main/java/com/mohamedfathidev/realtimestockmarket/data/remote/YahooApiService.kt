package com.mohamedfathidev.realtimestockmarket.data.remote

import com.mohamedfathidev.realtimestockmarket.data.model.remote.ChartApiResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface YahooApiService {

    @GET("v8/finance/chart/{symbol}")
    suspend fun getChart(
        @Path("symbol") symbol: String,
        @Query("interval") interval: String = "1h",
        @Query("range") range: String = "5d"
    ): ChartApiResult
}

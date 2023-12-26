package com.mohamedfathidev.realtimestockmarket.data.remote

import com.mohamedfathidev.realtimestockmarket.data.model.remote.EtfApiResponse
import com.mohamedfathidev.realtimestockmarket.data.model.remote.StockApiResponse
import retrofit2.http.GET

interface NasdaqApiService {

    @GET("api/screener/stocks?download=true")
    suspend fun getStocks(): StockApiResponse?

    @GET("api/screener/etf?download=true")
    suspend fun getEtfs(): EtfApiResponse?
}

package com.mohamedfathidev.realtimestockmarket.data.repository

import com.mohamedfathidev.realtimestockmarket.data.model.remote.ChartApiResult
import com.mohamedfathidev.realtimestockmarket.data.remote.YahooApiService
import com.mohamedfathidev.realtimestockmarket.domain.repository.ChartsRepository

class ChartsRepositoryImpl(
    private val yahooApiService: YahooApiService
) : ChartsRepository {
    override suspend fun getChart(symbol: String, interval: String, range: String): ChartApiResult =
        yahooApiService.getChart(symbol, interval, range)
}
package com.mohamedfathidev.realtimestockmarket.domain.repository

import com.mohamedfathidev.realtimestockmarket.data.model.remote.ChartApiResult

interface ChartsRepository {
    suspend fun getChart(symbol: String, interval: String, range: String): ChartApiResult
}
package com.mohamedfathidev.realtimestockmarket.domain.repository

import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface PreferencesRepository {
    suspend fun getEtfsUpdateDate(): LocalDate?
    suspend fun getStocksUpdateDate(): LocalDate?
    suspend fun setEtfsUpdateDate(value: LocalDate)
    suspend fun setStocksUpdateDate(value: LocalDate)
    fun getFavoritesStocks(): Flow<Set<String>>
    fun getFavoritesEtfs(): Flow<Set<String>>
    suspend fun toggleFavoritesStocks(symbol: String)
    suspend fun toggleFavoritesEtfs(symbol: String)
}
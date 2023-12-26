package com.mohamedfathidev.realtimestockmarket.domain.repository

import com.mohamedfathidev.realtimestockmarket.data.model.local.StockEntity
import kotlinx.coroutines.flow.Flow

interface StocksRepository {
    suspend fun insertStocks(entities: List<StockEntity>)
    fun getStocks(symbols: List<String>): Flow<List<StockEntity>>
    fun getStock(symbol: String): Flow<StockEntity?>
    fun findStocks(searchQuery: String): Flow<List<StockEntity>>
}
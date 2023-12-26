package com.mohamedfathidev.realtimestockmarket.data.repository

import com.mohamedfathidev.realtimestockmarket.data.local.StocksDao
import com.mohamedfathidev.realtimestockmarket.data.model.local.StockEntity
import com.mohamedfathidev.realtimestockmarket.domain.repository.StocksRepository
import com.mohamedfathidev.realtimestockmarket.domain.utils.toSafeString

class StocksRepositoryImpl(
    private val dao: StocksDao
) : StocksRepository {
    override suspend fun insertStocks(entities: List<StockEntity>) =
        dao.insertAll(entities)

    override fun getStocks(symbols: List<String>) =
        dao.getStocksBySymbols(symbols)

    override fun getStock(symbol: String) =
        dao.getStockBySymbol(symbol)

    override fun findStocks(searchQuery: String) =
        dao.findStocks(searchQuery.toSafeString() + "%")

}
package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.data.model.local.StockEntity
import com.mohamedfathidev.realtimestockmarket.domain.repository.StocksRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMostPopularStocksUseCase @Inject constructor(
    private val repository: StocksRepository
) {
    operator fun invoke(): Flow<List<StockEntity>> {
        return repository.getStocks(symbols)
    }

    private val symbols = listOf("IBM", "MSFT", "TSLA", "AAPL", "GOOG")
}
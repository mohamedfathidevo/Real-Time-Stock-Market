package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.data.model.local.toStockEntity
import com.mohamedfathidev.realtimestockmarket.data.remote.NasdaqApiService
import com.mohamedfathidev.realtimestockmarket.domain.repository.StocksRepository
import timber.log.Timber
import javax.inject.Inject

class UpdateStocksUseCase @Inject constructor(
    private val nasdaqApiService: NasdaqApiService,
    private val repository: StocksRepository
) {

    suspend operator fun invoke(): Boolean {
        try {
            val apiResponse = nasdaqApiService.getStocks() ?: return false
            repository.insertStocks(apiResponse.data.rows.map { it.toStockEntity() })
        } catch (e: Exception) {
            Timber.e(e)
            return false
        }

        return true
    }
}

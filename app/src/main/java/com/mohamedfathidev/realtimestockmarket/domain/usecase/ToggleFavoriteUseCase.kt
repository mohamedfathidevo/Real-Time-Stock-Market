package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.domain.repository.PreferencesRepository
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.InstrumentType
import javax.inject.Inject

class ToggleFavoriteUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(symbol: String, type: InstrumentType) {
        when (type) {
            InstrumentType.Stock -> preferencesRepository.toggleFavoritesStocks(symbol)
            InstrumentType.ETF -> preferencesRepository.toggleFavoritesEtfs(symbol)
        }
    }
}
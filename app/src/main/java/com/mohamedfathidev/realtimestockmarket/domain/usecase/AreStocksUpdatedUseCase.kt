package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.domain.repository.PreferencesRepository
import java.time.LocalDate
import javax.inject.Inject

class AreStocksUpdatedUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(): Boolean {
        val updatedAt = preferencesRepository.getStocksUpdateDate() ?: return false
        return updatedAt > LocalDate.now().minusDays(1)
    }
}
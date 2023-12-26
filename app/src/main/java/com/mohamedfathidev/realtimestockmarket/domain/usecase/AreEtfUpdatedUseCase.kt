package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.domain.repository.PreferencesRepository
import java.time.LocalDate
import javax.inject.Inject

class AreEtfUpdatedUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {
    suspend operator fun invoke(): Boolean {
        val updateAt = preferencesRepository.getEtfsUpdateDate() ?: return false
        return updateAt > LocalDate.now().minusDays(1)
    }
}
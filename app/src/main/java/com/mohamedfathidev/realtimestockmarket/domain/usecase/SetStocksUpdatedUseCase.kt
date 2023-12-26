package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.domain.repository.PreferencesRepository
import java.time.LocalDate
import javax.inject.Inject

class SetStocksUpdatedUseCase @Inject constructor(
    private val preferencesRepository: PreferencesRepository
) {

    suspend operator fun invoke() {
        preferencesRepository.setStocksUpdateDate(LocalDate.now())
    }
}

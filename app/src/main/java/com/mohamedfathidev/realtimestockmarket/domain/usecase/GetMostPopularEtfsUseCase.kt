package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.data.model.local.EtfEntity
import com.mohamedfathidev.realtimestockmarket.domain.repository.EtfRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMostPopularEtfsUseCase @Inject constructor(
    private val repository: EtfRepository
) {
    operator fun invoke(): Flow<List<EtfEntity>> {
        return repository.getEtfs(symbols)
    }

    private val symbols = listOf("AAAU", "IVE", "IVW")
}
package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.data.model.local.toEtfEntity
import com.mohamedfathidev.realtimestockmarket.data.remote.NasdaqApiService
import com.mohamedfathidev.realtimestockmarket.domain.repository.EtfRepository
import timber.log.Timber
import javax.inject.Inject

class UpdateEtfsUseCase @Inject constructor(
    private val nasdaqApiService: NasdaqApiService,
    private val repository: EtfRepository,
) {

    suspend operator fun invoke(): Boolean {
        try {
            val apiResponse = nasdaqApiService.getEtfs() ?: return false
            repository.insertEtfs(apiResponse.data.data.rows.map { it.toEtfEntity() })
        } catch (e: Exception) {
            Timber.e(e)
            return false
        }

        return true
    }
}

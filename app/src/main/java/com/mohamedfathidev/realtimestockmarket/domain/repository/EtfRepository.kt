package com.mohamedfathidev.realtimestockmarket.domain.repository

import com.mohamedfathidev.realtimestockmarket.data.model.local.EtfEntity
import kotlinx.coroutines.flow.Flow

interface EtfRepository {
    suspend fun insertEtfs(entities: List<EtfEntity>)
    fun getEtfs(symbols: List<String>): Flow<List<EtfEntity>>
    fun getEtf(symbol: String): Flow<EtfEntity?>
    fun findEtf(searchQuery: String): Flow<List<EtfEntity>>
}
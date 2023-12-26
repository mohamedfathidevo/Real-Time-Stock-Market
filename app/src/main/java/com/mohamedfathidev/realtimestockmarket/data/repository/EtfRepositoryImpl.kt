package com.mohamedfathidev.realtimestockmarket.data.repository

import com.mohamedfathidev.realtimestockmarket.data.local.EtfDao
import com.mohamedfathidev.realtimestockmarket.data.model.local.EtfEntity
import com.mohamedfathidev.realtimestockmarket.domain.repository.EtfRepository
import com.mohamedfathidev.realtimestockmarket.domain.utils.toSafeString

class EtfRepositoryImpl(
    private val dao: EtfDao
) : EtfRepository {
    override suspend fun insertEtfs(entities: List<EtfEntity>) =
        dao.insertAll(entities)


    override fun getEtfs(symbols: List<String>) = dao.getEtfsBySymbols(symbols)


    override fun getEtf(symbol: String) =
        dao.getEtfBySymbol(symbol)

    override fun findEtf(searchQuery: String) =
        dao.findEtfs(searchQuery.toSafeString() + "%")

}
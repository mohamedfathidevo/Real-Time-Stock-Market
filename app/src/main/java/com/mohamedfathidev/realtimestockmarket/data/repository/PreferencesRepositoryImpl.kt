package com.mohamedfathidev.realtimestockmarket.data.repository

import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey
import com.mohamedfathidev.realtimestockmarket.domain.repository.PreferencesRepository
import java.time.LocalDate

class PreferencesRepositoryImpl(
    private val store: DataStoreWrapper
) : PreferencesRepository {
    override suspend fun getEtfsUpdateDate(): LocalDate? =
        store.getLocalDate(ETFS_UPDATED_AT)


    override suspend fun getStocksUpdateDate(): LocalDate? =
        store.getLocalDate(STOCKS_UPDATED_AT)


    override suspend fun setEtfsUpdateDate(value: LocalDate) =
        store.setLocalDate(ETFS_UPDATED_AT, value)


    override suspend fun setStocksUpdateDate(value: LocalDate) =
        store.setLocalDate(STOCKS_UPDATED_AT, value)


    override fun getFavoritesStocks() =
        store.getStringSet(FAV_STOCKS)

    override fun getFavoritesEtfs() =
        store.getStringSet(FAV_ETFS)

    override suspend fun toggleFavoritesStocks(symbol: String) =
        store.toggleStringSet(FAV_STOCKS, symbol)


    override suspend fun toggleFavoritesEtfs(symbol: String) =
        store.toggleStringSet(FAV_ETFS, symbol)


    companion object {
        private val STOCKS_UPDATED_AT = stringPreferencesKey("stocks_updated_at")
        private val ETFS_UPDATED_AT = stringPreferencesKey("etfs_updated_at")
        private val FAV_STOCKS = stringSetPreferencesKey("fav_stocks")
        private val FAV_ETFS = stringSetPreferencesKey("fav_etfs")
    }

}
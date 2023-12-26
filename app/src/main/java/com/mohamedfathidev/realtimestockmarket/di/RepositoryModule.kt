package com.mohamedfathidev.realtimestockmarket.di

import com.mohamedfathidev.realtimestockmarket.data.local.EtfDao
import com.mohamedfathidev.realtimestockmarket.data.local.StocksDao
import com.mohamedfathidev.realtimestockmarket.data.remote.YahooApiService
import com.mohamedfathidev.realtimestockmarket.data.repository.ChartsRepositoryImpl
import com.mohamedfathidev.realtimestockmarket.data.repository.DataStoreWrapper
import com.mohamedfathidev.realtimestockmarket.data.repository.EtfRepositoryImpl
import com.mohamedfathidev.realtimestockmarket.data.repository.PreferencesRepositoryImpl
import com.mohamedfathidev.realtimestockmarket.data.repository.StocksRepositoryImpl
import com.mohamedfathidev.realtimestockmarket.domain.repository.ChartsRepository
import com.mohamedfathidev.realtimestockmarket.domain.repository.EtfRepository
import com.mohamedfathidev.realtimestockmarket.domain.repository.PreferencesRepository
import com.mohamedfathidev.realtimestockmarket.domain.repository.StocksRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    fun provideChartsRepository(
        yahooApiService: YahooApiService
    ): ChartsRepository {
        return ChartsRepositoryImpl(
            yahooApiService
        )
    }

    @Provides
    fun provideEtfRepository(
        dao: EtfDao
    ): EtfRepository {
        return EtfRepositoryImpl(
            dao
        )
    }

    @Provides
    fun providePreferencesRepository(
        store: DataStoreWrapper
    ): PreferencesRepository {
        return PreferencesRepositoryImpl(
            store
        )
    }

    @Provides
    fun provideStocksRepository(
        dao: StocksDao
    ): StocksRepository {
        return StocksRepositoryImpl(
            dao
        )
    }
}
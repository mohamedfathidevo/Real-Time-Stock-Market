package com.mohamedfathidev.realtimestockmarket.domain.usecase

import com.mohamedfathidev.realtimestockmarket.domain.repository.EtfRepository
import com.mohamedfathidev.realtimestockmarket.domain.repository.StocksRepository
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.ListItem
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.toInstrumentItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SearchStocksAndEtfsUseCase @Inject constructor(
    private val stocksRepository: StocksRepository,
    private val etfRepository: EtfRepository
) {

    operator fun invoke(text: String): Flow<List<ListItem.InstrumentItem>> {
        return stocksRepository
            .findStocks(text).map { it.map { item -> item.toInstrumentItem() } }
            .combine(
                etfRepository.findEtf(text)
                    .map { it.map { item -> item.toInstrumentItem() } }
            ) { stocks, etfs ->
                stocks + etfs
            }
    }
}

package com.mohamedfathidev.realtimestockmarket.ui.details.screen

import com.himanshoe.charty.candle.model.CandleEntry
import com.mohamedfathidev.realtimestockmarket.data.model.local.InstrumentEntity
import com.mohamedfathidev.realtimestockmarket.domain.usecase.SelectableRangeInterval
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.ListItem
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.toInstrumentItem

data class DetailState(
    val isLoading: Boolean = true,
    val instrument: ListItem.InstrumentItem? = null,
    val candleStickData: List<CandleEntry> = emptyList(),
    val yAxis: List<String> = emptyList(),
    val rangeIntervals: List<SelectableRangeInterval> = emptyList(),
    val details: Map<String, String> = emptyMap(),
    val isFavorite: Boolean = false
) {
    fun setInstrumentEntity(entity: InstrumentEntity): DetailState {
        return copy(
            instrument = entity.toInstrumentItem(),
            details = entity.getDetails()
        )
    }
}
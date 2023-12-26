package com.mohamedfathidev.realtimestockmarket.ui.details.screen

import com.mohamedfathidev.realtimestockmarket.domain.usecase.RangeInterval

sealed class DetailIntent {
    object NavigateHome : DetailIntent()
    object ToggleFav : DetailIntent()
    object Refresh : DetailIntent()
    data class SelectRangeInterval(val rangeInterval: RangeInterval) : DetailIntent()
}

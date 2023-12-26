package com.mohamedfathidev.realtimestockmarket.ui.details.screen

sealed class DetailSideEffect {
    object NavigateHome : DetailSideEffect()
    object NetworkError : DetailSideEffect()
}
package com.mohamedfathidev.realtimestockmarket.ui.common

interface IntentHandler<INTENT : Any> {
    fun handleIntent(intent: INTENT)
}
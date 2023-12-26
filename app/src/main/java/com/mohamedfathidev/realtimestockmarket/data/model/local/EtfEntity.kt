package com.mohamedfathidev.realtimestockmarket.data.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mohamedfathidev.realtimestockmarket.data.model.remote.EtfDto
import com.mohamedfathidev.realtimestockmarket.domain.utils.toNumericString
import com.mohamedfathidev.realtimestockmarket.ui.home.screen.InstrumentType


@Entity(tableName = "etfs")
data class EtfEntity(
    @PrimaryKey override val symbol: String,
    override val companyName: String,
    override val lastSalePrice: Double,
    override val percentageChange: Double,
) : InstrumentEntity {
    override fun getType() = InstrumentType.ETF
    override fun getDetails() =
        mutableMapOf<String, String>().apply {
            set("Name", companyName)
        }
}

fun EtfDto.toEtfEntity() = EtfEntity(
    symbol = symbol,
    companyName = companyName,
    lastSalePrice = lastSalePrice.toNumericString().toDoubleOrNull() ?: 0.0,
    percentageChange = percentageChange.toNumericString().toDoubleOrNull() ?: 0.0
)

package com.mohamedfathidev.realtimestockmarket.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mohamedfathidev.realtimestockmarket.data.model.local.EtfEntity
import com.mohamedfathidev.realtimestockmarket.data.model.local.StockEntity


@Database(entities = [StockEntity::class, EtfEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun stocksDao(): StocksDao
    abstract fun etfDao(): EtfDao
}

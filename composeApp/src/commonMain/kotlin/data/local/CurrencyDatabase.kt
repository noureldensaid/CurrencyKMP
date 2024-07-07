package data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import data.local.entity.LatestExchangeRateEntity

@Database(entities = [LatestExchangeRateEntity::class], version = 1)
abstract class CurrencyDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}

internal const val dbFileName = "currency.db"

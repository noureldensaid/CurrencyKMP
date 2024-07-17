package org.coinz.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.coinz.data.local.entity.CurrencyConverter
import org.coinz.data.local.entity.LatestExchangeRateEntity

@Database(entities = [LatestExchangeRateEntity::class], version = 1)
@TypeConverters(CurrencyConverter::class)
abstract class CurrencyDatabase : RoomDatabase(), DB {

    abstract fun currencyDao(): CurrencyDao

    override fun clearAllTables() {
        super.clearAllTables()
    }

}

internal const val dbFileName = "currency.db"


// FIXME: Added a hack to resolve below issue:
// Class 'AppDatabase_Impl' is not abstract and does not implement abstract base class member 'clearAllTables'.
interface DB {
    fun clearAllTables() {}
}
package data.local

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): CurrencyDatabase {
    val dbFile = NSHomeDirectory() + "/$dbFileName"
    return Room.databaseBuilder<CurrencyDatabase>(
        name = dbFile,
        factory = { CurrencyDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
package org.coinz.data.local.database

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

fun getDatabaseBuilder(): CurrencyDatabase {
    val dbFile = NSHomeDirectory() + "/$dbFileName"
    return Room.databaseBuilder<CurrencyDatabase>(
        name = dbFile,
        factory = { CurrencyDatabase::class.instantiateImpl() }
    ).setDriver(BundledSQLiteDriver())
        .fallbackToDestructiveMigration(true)
        .build()
}


package data.local

import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import platform.Foundation.NSHomeDirectory

//fun createRoomDatabase(): CurrencyDatabase {
//    val dbFile = NSHomeDirectory() + "/$dbFileName"
//    return Room.databaseBuilder<CurrencyDatabase>(
//        name = dbFile,
//        factory = { CurrencyDatabase::class.instantiateImpl() }
//    ).setDriver(BundledSQLiteDriver()).build()
//}
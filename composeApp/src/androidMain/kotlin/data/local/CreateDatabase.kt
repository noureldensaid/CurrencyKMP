package data.local

import android.content.Context
import androidx.room.Room
import androidx.sqlite.driver.bundled.BundledSQLiteDriver
import kotlinx.coroutines.Dispatchers

fun createRoomDatabase(ctx: Context): CurrencyDatabase {
    val dbFile = ctx.getDatabasePath(dbFileName)
    return Room.databaseBuilder<CurrencyDatabase>(ctx, dbFile.absolutePath)
        .setDriver(BundledSQLiteDriver())
        .setQueryCoroutineContext(Dispatchers.IO)
        .build()
}
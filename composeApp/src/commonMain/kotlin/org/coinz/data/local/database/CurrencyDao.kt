package org.coinz.data.local.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import org.coinz.data.local.entity.LatestExchangeRateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {
    @Upsert
    suspend fun insertLatestExchangeRate(latestExchangeRateEntity: LatestExchangeRateEntity)

    @Delete
    suspend fun deleteLatestExchangeRate(latestExchangeRateEntity: LatestExchangeRateEntity)


    @Query("SELECT * FROM LatestExchangeRateEntity LIMIT 1")
    fun getLatestExchangeRate(): Flow<LatestExchangeRateEntity?>?


    // is org.coinz.data.local.database empty
    @Query("SELECT COUNT(*) FROM LatestExchangeRateEntity")
    suspend fun isDatabaseEmpty(): Boolean?

}
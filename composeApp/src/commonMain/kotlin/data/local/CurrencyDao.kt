package data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import data.local.entity.LatestExchangeRateEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {
    @Upsert
    suspend fun insertLatestExchangeRate(latestExchangeRateEntity: LatestExchangeRateEntity)

    @Delete
    suspend fun deleteLatestExchangeRate(latestExchangeRateEntity: LatestExchangeRateEntity)

    @Query("SELECT * FROM LatestExchangeRateEntity")
    fun getLatestExchangeRate(): Flow<LatestExchangeRateEntity>?
}
package data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LatestExchangeRateEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val lastUpdatedAt: String,
    val currencies: Map<String, CurrencyEntity>
)

@Entity
data class CurrencyEntity(
    val code: String,
    val value: Double
)
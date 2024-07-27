package org.coinz.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import org.coinz.domain.repository.DataStoreRepository

class DataStoreRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {


    override fun getLastUpdated(): Flow<Long?> {
        return dataStore.data.map {
            it[TIMESTAMP_KEY]
        }
    }

    override suspend fun saveLastUpdated(value: String) {
        dataStore.edit {
            it[TIMESTAMP_KEY] = Instant.parse(value).toEpochMilliseconds()
        }
    }

    override suspend fun clearPreferences() {
        dataStore.edit {
            it.clear()
        }
    }

    override suspend fun isDataFresh(currentTimeStamp: Long): Boolean {
        val savedTimestamp = getLastUpdated().map { it ?: 0L }.first()
        return if(savedTimestamp != 0L){
            val currentTimeInstant = Instant.fromEpochMilliseconds(currentTimeStamp)
            val savedTimeStamp = Instant.fromEpochMilliseconds(savedTimestamp)

            val currentDate = currentTimeInstant.toLocalDateTime(TimeZone.currentSystemDefault())
            val savedDate = savedTimeStamp.toLocalDateTime(TimeZone.currentSystemDefault())
            val diff = currentDate.date.daysUntil(savedDate.date)

            (diff < 1)

        } else {
            false
        }
    }


    companion object {
        val TIMESTAMP_KEY = longPreferencesKey("lastUpdated")
    }
}
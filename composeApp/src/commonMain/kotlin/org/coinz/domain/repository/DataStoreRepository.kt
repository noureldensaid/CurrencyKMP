package org.coinz.domain.repository

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    fun getLastUpdated(): Flow<Long?>
    suspend fun saveLastUpdated(value: String)
    suspend fun clearPreferences()
    suspend fun isDataFresh(currentTimeStamp: Long): Boolean
}
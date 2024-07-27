package org.coinz.data.local.dataStorePreferences

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath
import org.coinz.util.Constants.DATA_STORE_FILE_NAME

fun createDataStore(context: Context): DataStore<Preferences> {
    val producePath = { context.filesDir.resolve(DATA_STORE_FILE_NAME).absolutePath }
    return PreferenceDataStoreFactory.createWithPath(
        produceFile = { producePath().toPath() }
    )
}



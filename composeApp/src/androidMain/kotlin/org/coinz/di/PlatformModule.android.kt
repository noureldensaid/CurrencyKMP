package org.coinz.di

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import org.coinz.data.local.dataStorePreferences.createDataStore
import org.coinz.data.local.database.CurrencyDatabase
import org.coinz.data.local.database.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<CurrencyDatabase> {
            getDatabaseBuilder(get())
        }

        single<DataStore<Preferences>> {
            createDataStore(get())
        }

    }
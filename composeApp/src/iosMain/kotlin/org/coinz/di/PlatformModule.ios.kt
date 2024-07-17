package org.coinz.di

import org.coinz.data.local.database.CurrencyDatabase
import org.coinz.data.local.database.getDatabaseBuilder
import org.koin.core.module.Module
import org.koin.dsl.module

actual val platformModule: Module
    get() = module {
        single<CurrencyDatabase> {
            getDatabaseBuilder()
        }
    }
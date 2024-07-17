package org.coinz.di

import org.coinz.data.remote.ApiService
import org.coinz.data.remote.createKtorClient
import org.coinz.data.repository.RepositoryImpl
import org.coinz.domain.repository.Repository
import org.coinz.domain.useCases.FetchDataUseCase
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import org.coinz.presentation.home.viewmodel.HomeViewModel

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(appModule,platformModule)
    }
}

val appModule = module {
    single {
        createKtorClient()
    }
    single { ApiService(get()) }
    singleOf(::RepositoryImpl).bind(Repository::class)
    viewModel { HomeViewModel(get(),get()) }


    single {FetchDataUseCase(get())}



}


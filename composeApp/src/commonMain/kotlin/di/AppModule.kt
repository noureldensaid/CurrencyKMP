package di

import common.Constants.API_KEY
import data.remote.ApiService
import data.repository.RepositoryImpl
import domain.repository.Repository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.headers
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.compose.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import presentation.HomeViewModel

val appModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                })
            }
            install(HttpTimeout) {
                requestTimeoutMillis = 15000
            }
            install(Logging) {
                level = LogLevel.BODY
            }
            install(DefaultRequest) {
                headers {
                    append("apikey", API_KEY)
                }
            }
        }
    }
    single { ApiService(get()) }
    single { RepositoryImpl(get()) }.bind<Repository>()
     viewModel { HomeViewModel(get()) }

}
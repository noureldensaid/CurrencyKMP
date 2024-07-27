package org.coinz.data.repository

import org.coinz.data.local.database.CurrencyDatabase
import org.coinz.data.remote.ApiService
import org.coinz.data.remote.dto.toEntity
import org.coinz.data.remote.dto.toModel
import org.coinz.domain.models.LatestExchangeRateModel
import org.coinz.domain.repository.Repository
import org.coinz.util.NetworkError
import org.coinz.util.Result
import org.coinz.util.map

class RepositoryImpl(
    private val apiService: ApiService,
    private val currencyDatabase: CurrencyDatabase
) : Repository {

    override suspend fun getLatestExchangeRates(): Result<LatestExchangeRateModel, NetworkError> {
        val response = apiService.getLatestExchangeRates()
        val dao = currencyDatabase.currencyDao()
        if (response is Result.Success) {
            dao.insertLatestExchangeRate(response.data.toEntity())


        }
        return response.map {
            it.toModel()
        }
    }
}


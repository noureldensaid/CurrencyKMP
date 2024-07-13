package data.repository

import data.remote.ApiService
import data.remote.dto.toModel
import domain.models.LatestExchangeRateModel
import domain.repository.Repository
import util.Error
import util.Result
import util.map

class RepositoryImpl(
    private val apiService: ApiService
) : Repository {
    override suspend fun getLatestExchangeRates(): Result<LatestExchangeRateModel, Error> {
        val response = apiService.getLatestExchangeRates()
        return response.map {
            it.toModel()
        }
    }

}


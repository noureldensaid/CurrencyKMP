package org.coinz.domain.useCases

import kotlinx.coroutines.flow.collectLatest
import kotlinx.datetime.Clock
import org.coinz.data.local.database.CurrencyDatabase
import org.coinz.data.local.entity.toModel
import org.coinz.domain.models.LatestExchangeRateModel
import org.coinz.domain.repository.DataStoreRepository
import org.coinz.domain.repository.Repository
import org.coinz.util.DataBaseError
import org.coinz.util.Error
import org.coinz.util.Result


class FetchDataUseCase(
    private val repository: Repository,
    private val dataStoreRepository: DataStoreRepository,
    private val database: CurrencyDatabase
) {

    suspend operator fun invoke(): Result<LatestExchangeRateModel, Error> {
        var result: Result<LatestExchangeRateModel, Error> = Result.Idle
        val isDataFresh = dataStoreRepository.isDataFresh(Clock.System.now().toEpochMilliseconds())
        if (!isDataFresh) {
            result = repository.getLatestExchangeRates()
            if (result is Result.Success) {
                dataStoreRepository.saveLastUpdated(result.data.lastUpdatedAt)
            }
            return result
        } else {
            database.currencyDao().getLatestExchangeRate()?.collect { data ->
                result = data?.toModel()?.let { Result.Success(it) }
                    ?: Result.Error(DataBaseError.NOT_FOUND)
            }
        }
        return result
    }
}
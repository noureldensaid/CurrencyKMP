package org.coinz.presentation.home.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import org.coinz.data.local.database.CurrencyDatabase
import org.coinz.data.local.entity.toModel
import org.coinz.domain.models.LatestExchangeRateModel
import org.coinz.domain.repository.Repository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.coinz.domain.repository.DataStoreRepository
import org.coinz.domain.useCases.FetchDataUseCase
import org.coinz.util.Error
import org.coinz.util.Result

class HomeViewModel(
    private val fetchDataUseCase: FetchDataUseCase
) : ViewModel() {



    var data by mutableStateOf<Result<LatestExchangeRateModel?, Error>>(Result.Idle)

    fun loadHomeSections() {
        viewModelScope.launch {
            data = fetchDataUseCase()
//            if (database.currencyDao().isDatabaseEmpty() == false) {
//                val response = repo.getLatestExchangeRates()
//                data = response
//            } else {
//                val x = database.currencyDao().getLatestExchangeRate()
//                x?.collectLatest {
//                    data = Result.Success(it?.toModel())
//                }
//            }
        }
    }

}
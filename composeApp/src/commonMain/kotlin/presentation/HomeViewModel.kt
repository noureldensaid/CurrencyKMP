package presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import common.RequestState
import domain.models.LatestExchangeRateModel
import domain.repository.Repository
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repo: Repository,
) : ViewModel() {

    var data by mutableStateOf<RequestState<LatestExchangeRateModel>>(RequestState.Loading)

    fun loadHomeSections() {
        viewModelScope.launch {
            val x = repo.getLatestExchangeRates()
            data = x
        }
    }

}
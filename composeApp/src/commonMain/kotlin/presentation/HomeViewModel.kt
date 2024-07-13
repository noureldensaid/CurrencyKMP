package presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.models.LatestExchangeRateModel
import domain.repository.Repository
import kotlinx.coroutines.launch
import util.Error
import util.Result

class HomeViewModel(
    private val repo: Repository,
) : ViewModel() {

    var data by mutableStateOf<Result<LatestExchangeRateModel, Error>>(Result.Idle)

    fun loadHomeSections() {
        viewModelScope.launch {
            val x = repo.getLatestExchangeRates()
            data = x
        }
    }

}
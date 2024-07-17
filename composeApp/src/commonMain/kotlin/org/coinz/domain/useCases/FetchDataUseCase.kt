package org.coinz.domain.useCases

import org.coinz.domain.repository.Repository

class FetchDataUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke() {
        // check if the database is empty
    }

}
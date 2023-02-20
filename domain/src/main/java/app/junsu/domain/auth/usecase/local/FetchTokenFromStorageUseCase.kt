package app.junsu.domain.auth.usecase.local

import app.junsu.domain.auth.repository.LocalAuthRepository
import app.junsu.model.common.Token
import javax.inject.Inject

class FetchTokenFromStorageUseCase @Inject constructor(
    private val localAuthRepository: LocalAuthRepository,
) {
    suspend operator fun invoke(): Token {
        return localAuthRepository.fetchTokenFromStorage()
    }
}

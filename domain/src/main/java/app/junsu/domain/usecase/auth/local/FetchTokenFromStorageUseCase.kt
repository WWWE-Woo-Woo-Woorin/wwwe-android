package app.junsu.domain.usecase.auth.local

import app.junsu.domain.repository.auth.local.LocalAuthRepository
import app.junsu.model.common.Token
import javax.inject.Inject

class FetchTokenFromStorageUseCase @Inject constructor(
    private val localAuthRepository: LocalAuthRepository,
) {
    suspend operator fun invoke(): Token {
        return localAuthRepository.fetchTokenFromStorage()
    }
}

package app.junsu.domain.usecase.auth.local

import app.junsu.domain.repository.auth.local.LocalAuthRepository
import javax.inject.Inject

class SaveEmailUseCase @Inject constructor(
    private val localAuthRepository: LocalAuthRepository,
) {
    suspend operator fun invoke(
        email: String,
    ) {
        localAuthRepository.saveEmail(
            email = email,
        )
    }
}

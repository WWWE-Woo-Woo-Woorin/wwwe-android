package app.junsu.domain.auth.usecase.local

import app.junsu.domain.auth.repository.LocalAuthRepository
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
